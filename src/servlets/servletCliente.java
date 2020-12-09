package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Cliente;
import Models.Prestamos;
import Models.Usuario;
import daoImpl.ClienteDaoImpl;
import daoImpl.PrestamosDaoImpl;
import negocioImpl.ClienteNegocioImpl;
import negocioImpl.UsuarioNegocioImpl;


@WebServlet("/servletCliente")
public class servletCliente extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       

    public servletCliente() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnMisDatos") != null)
		{
			ClienteDaoImpl clienteDao = new ClienteDaoImpl();
			Cliente cliente = clienteDao.obtenerCliente((Integer)request.getSession().getAttribute("dniLogeado"));
			
			request.setAttribute("clienteLogeado", cliente);
			
			RequestDispatcher rd = request.getRequestDispatcher("MisDatos.jsp");
			rd.forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClienteNegocioImpl clienteNegocio = new ClienteNegocioImpl();
		Cliente cliente = new Cliente();
		UsuarioNegocioImpl usuarioNegocio = new UsuarioNegocioImpl();
		Usuario usuario = new Usuario();
		
		usuario.setDni(Integer.parseInt(request.getParameter("txtDni")));
		usuario.setContraseña(request.getParameter("txtContraseña"));
		usuario.setTipoUsuario(2);
		
		
		
		String date = request.getParameter("dateFechaNac");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
		try {
			Date fecha = simpleDateFormat.parse(date);
			
			java.sql.Date sqlDate = new java.sql.Date(fecha.getTime()); 
			cliente.setFechaNac(sqlDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cliente.setNombre(request.getParameter("txtNombre"));
		cliente.setApellido(request.getParameter("txtApellido"));
		cliente.setActivo(true);
		cliente.setDni(Integer.parseInt(request.getParameter("txtDni")));
		cliente.setCuil(Integer.parseInt(request.getParameter("txtCuil")));
		cliente.setSexo(request.getParameter("txtSexo"));
		cliente.setDireccion(request.getParameter("txtDireccion"));
		cliente.setNacionalidad(request.getParameter("txtNacionalidad"));
		cliente.setProvincia(request.getParameter("txtProvincia"));
		cliente.setLocalidad(request.getParameter("txtLocalidad"));
		cliente.setMail(request.getParameter("txtMail"));
		cliente.setTelefono(Integer.parseInt(request.getParameter("txtTelefono")));
		cliente.setUsuario(usuario);
		
		int registroExitosoUsuario = usuarioNegocio.agregarUsuario(usuario);
		boolean registroExitosoCliente = clienteNegocio.Insert(cliente);
		
		if(registroExitosoUsuario==1&&registroExitosoCliente==true)
		{
			//Se registro con exito
			request.setAttribute("registro", true);
		}
		else
		{
			request.setAttribute("registro", false);
		}
		
		
		//request.setAttribute("cantFilas", filas);
		RequestDispatcher rd = request.getRequestDispatcher("AgregarCliente.jsp");   
        rd.forward(request, response);
		doGet(request, response);
	}

}
