package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Cliente;
import Models.CuentasPorClientes;
import Models.Movimientos;
import Models.Prestamos;
import Models.Usuario;
import daoImpl.CuentasDaoImpl;
import daoImpl.MovimientosDaoImpl;
import daoImpl.PrestamosDaoImpl;
import negocioImpl.ClienteNegocioImpl;
import negocioImpl.PrestamoNegocioImpl;
import negocioImpl.UsuarioNegocioImpl;

/**
 * Servlet implementation class servletPrestamo
 */
@WebServlet("/servletPrestamo")
public class servletPrestamo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public servletPrestamo() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		if(request.getParameter("btnMostrarPrestamos") != null)
		{
			PrestamosDaoImpl prestamosDao = new PrestamosDaoImpl();
			ArrayList<Prestamos> lista = prestamosDao.obtenerPrestamos((Integer)request.getSession().getAttribute("dniLogeado"));
			
			request.setAttribute("listaP", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("ListarPrestamos.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnMostrarPrestamosAdmin") != null)
		{
			PrestamosDaoImpl prestamosDao = new PrestamosDaoImpl();
			ArrayList<Prestamos> lista = prestamosDao.obtenerTodosLosPrestamosPorEstado("Pendiente");
			
			request.setAttribute("listaP", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("ListarPrestamosAdmin.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnMostrarPrestamosAceptados") != null)
		{
			PrestamosDaoImpl prestamosDao = new PrestamosDaoImpl();
			ArrayList<Prestamos> lista = prestamosDao.obtenerTodosLosPrestamosPorEstado("Aceptado");
			
			request.setAttribute("listaP", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("PagarPrestamos.jsp");
			rd.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnSolicitar") != null)
		{
			
			PrestamoNegocioImpl prestamoNegocio = new PrestamoNegocioImpl();
			Prestamos prestamo = new Prestamos();
			prestamo.setDniCliente((Integer)request.getSession().getAttribute("dniLogeado"));
			prestamo.setCuotasRestantes(Integer.parseInt(request.getParameter("txtCuotas")));
			prestamo.setCuotasTotales(Integer.parseInt(request.getParameter("txtCuotas")));
			prestamo.setImportePedido(Float.parseFloat(request.getParameter("txtCantidad")));
			prestamo.setImporteAPagar(Float.parseFloat(request.getParameter("txtCantidad")));
		 	prestamo.setNroCuenta(Integer.parseInt(request.getParameter("ClientesCuenta")));
		 	prestamo.setEstado("Pendiente");
		 	
		 	Date date = Calendar.getInstance().getTime();  
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
			simpleDateFormat.format(date);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
			prestamo.setFecha(sqlDate);
		
			int registroExitosoUsuario = prestamoNegocio.agregarPrestamo(prestamo);
			
		//	if (registroExitosoUsuario==0){}
			
			prestamoNegocio.crearTablaCuotas(prestamo);
			
			
			//request.setAttribute("cantFilas", filas);
			RequestDispatcher rd = request.getRequestDispatcher("InicioCliente.jsp");   
	        rd.forward(request, response);
			doGet(request, response);
			 
		}
		
		if(request.getParameter("btnPagar") != null)
		{
			boolean verificacion=false;
			int saldo = 0;
			int importe = 0;
			int cuotasRestantes = 0;
			int idPrestamo = Integer.parseInt( request.getParameter("idPrestamoUsu"));	
		 	int nroCuenta = (Integer.parseInt(request.getParameter("ClientesCuenta")));
		 	int cantidadCuotas = (Integer.parseInt(request.getParameter("txtCuotas")));
		 	
			PrestamosDaoImpl pd = new PrestamosDaoImpl();		
			CuentasDaoImpl cd = new CuentasDaoImpl();
			
			saldo = cd.obtenerSaldoCuentaPornroCuenta(nroCuenta);
			importe = pd.obtenerValorCuota(idPrestamo, cantidadCuotas);
			cuotasRestantes = pd.obtenerCuotasRestantes(idPrestamo);
			
			if(saldo>=importe && cantidadCuotas<=cuotasRestantes) 
			{
			pd.pagarPrestamo(idPrestamo,importe,cantidadCuotas);
			cd.pagarPrestamo(nroCuenta, importe);
			Date date = Calendar.getInstance().getTime();  
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
			simpleDateFormat.format(date);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 			
			MovimientosDaoImpl md = new MovimientosDaoImpl();
			Movimientos movimiento = new Movimientos();
			movimiento.setFecha(sqlDate);
			movimiento.setImporte(importe);
			movimiento.setNroCuenta(nroCuenta);
			movimiento.setTipoMovimiento(2);
			movimiento.setConcepto("Pago de "+cantidadCuotas+" por un total de "+importe);
			md.agregarMovimientoPagos(movimiento);
	
			
			verificacion = true;
			}
			
			request.setAttribute("estadoSaldo", verificacion);
			RequestDispatcher rd = request.getRequestDispatcher("PagarPrestamos.jsp");   
	        rd.forward(request, response);
			doGet(request, response);
			 
		}
		if(request.getParameter("btnEliminar") != null)
		 {
			 int id = Integer.parseInt( request.getParameter("idPrestamoUsu"));
			 PrestamosDaoImpl pd = new PrestamosDaoImpl();
			 pd.modificarEstadoAceptado(id,"Rechazado");
			 
			 ArrayList<Prestamos> Lista1 = null;

			 PrestamosDaoImpl Seg1 = new PrestamosDaoImpl();
			 Lista1 =  Seg1.obtenerTodosLosPrestamosPorEstado("Pendiente");
			 
			 request.setAttribute("listaP", Lista1);	 
		      RequestDispatcher rd = request.getRequestDispatcher("ListarPrestamosAdmin.jsp");
		      rd.forward(request, response);		 
		 }
		
		if(request.getParameter("btnAceptar") != null)
		 {
			CuentasDaoImpl cd = new CuentasDaoImpl();
		
			 int id = Integer.parseInt( request.getParameter("idPrestamoUsu"));
			 PrestamosDaoImpl pd = new PrestamosDaoImpl();
			
			 pd.modificarEstadoAceptado(id,"Aceptado");
			 cd.modificarCuentaPrestamoAceptado(id);
			 ArrayList<Prestamos> Lista1 = null;

			 PrestamosDaoImpl Seg1 = new PrestamosDaoImpl();
			 Lista1 =  Seg1.obtenerTodosLosPrestamosPorEstado("Pendiente");
			 
			 request.setAttribute("listaP", Lista1);	 
		      RequestDispatcher rd = request.getRequestDispatcher("ListarPrestamosAdmin.jsp");
		      rd.forward(request, response);		 
		 }
		doGet(request, response);
	}

}
