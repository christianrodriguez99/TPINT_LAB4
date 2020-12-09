package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.CuentasPorClientes;
import Models.Prestamos;
import daoImpl.CuentasDaoImpl;
import daoImpl.MovimientosDaoImpl;
import daoImpl.PrestamosDaoImpl;
import negocioImpl.CuentasNegocioImpl;


@WebServlet("/servletCuentas")
public class servletCuentas extends HttpServlet {

	private static final long serialVersionUID = 1L;
       

    public servletCuentas() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		
		  if(request.getParameter("btnMostrarCuentas") != null)
  		{
      	  	CuentasDaoImpl cuentasDao = new CuentasDaoImpl();
  			ArrayList<CuentasPorClientes> lista = cuentasDao.obtenerCuentasxCliente((Integer)request.getSession().getAttribute("dniLogeado"));
  			
  			request.setAttribute("listaC", lista);
  			
  			RequestDispatcher rd = request.getRequestDispatcher("ListarCuentas.jsp");
  			rd.forward(request, response);
  		}
		
		String ComboCuentas = "";
		int ComboDni = 0;
		String Consulta = "";
		int TC=0;
		int filas = 0;
		
		Random RR = new Random();
		int numero2 =  1000000000+ RR.nextInt(1000300700);
			
		int num = 1000000000+ RR.nextInt(1000300700);
			
		 if (request.getParameter("btnAceptar") != null)
		 {
				CuentasDaoImpl cuentasDao = new CuentasDaoImpl();
			 ComboCuentas = request.getParameter("TiposCuentaCombobox");
			 ComboDni =  Integer.parseInt(request.getParameter("ClientesDNI"));
			 int contador =  cuentasDao.obtenerCantidadCuentas(ComboDni);
			 
			 switch(ComboCuentas)
		        {
		            case "Caja de ahorro":
		            	 TC = 1;
		                break;
		            case "Cuenta corriente":
		            	TC = 2;
		                break;
		             
		            default:
		                 
		        }
			 if(contador<3)
			 {
			 Consulta = "Insert into cuentas   values ("+num+" ,"+ComboDni+","+TC+",time (NOW()),"+numero2+", 10000  )";
		 
		 CuentasDaoImpl cd = new CuentasDaoImpl();
		 
		 filas = cd.agregarCuenta(Consulta);
		 request.setAttribute("CantFilas", filas);	 
			 }
			 else
			 {
				 
				request.setAttribute("maximoAlcanzado", contador);	 
			 }
		 }

	
      RequestDispatcher rd = request.getRequestDispatcher("AgregaCuenta.jsp");
      rd.forward(request, response);
      
    
     
    	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("MuestraCuenta") != null)
		{
			 CuentasDaoImpl Seg1 = new CuentasDaoImpl();
			 ArrayList<CuentasPorClientes> Lista1 = null;
			 Lista1 =  Seg1.obtenerCuentasClientes();
			 
			 request.setAttribute("ListaCC", Lista1);	 
		      RequestDispatcher rd = request.getRequestDispatcher("EliminarCuentas.jsp");
		      rd.forward(request, response);
		}
		
		if(request.getParameter("BtnElimina") != null)
		 {
			 int id = Integer.parseInt( request.getParameter("NumCuentaUsu"));
			 CuentasDaoImpl cd = new CuentasDaoImpl();
			 cd.eliminarCuentaUsuario(id);
			 System.out.println("NUMERO  "+id );
			 
			 ArrayList<CuentasPorClientes> Lista1 = null;

			 CuentasDaoImpl Seg1 = new CuentasDaoImpl();
			 Lista1 =  Seg1.obtenerCuentasClientes();
			 
			 request.setAttribute("ListaCC", Lista1);	 
		      RequestDispatcher rd = request.getRequestDispatcher("EliminarCuentas.jsp");
		      rd.forward(request, response);		 
		 }
	}
	
}
