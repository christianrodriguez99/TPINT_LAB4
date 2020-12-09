package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.Cliente;
import Models.Usuario;
import daoImpl.ClienteDaoImpl;
import daoImpl.UsuarioDaoImpl;


@WebServlet("/servletUsuario")
public class servletUsuario extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public servletUsuario()
    {
        super();    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();
		ClienteDaoImpl clienteDao = new ClienteDaoImpl();
		Cliente x = new Cliente();
		Usuario y = new Usuario();
		int tipoUsuario = 0; 
		
	    boolean verificacion = false;
	    String nombreUsuario;
	    RequestDispatcher rd = null;
		
		 if(request.getParameter("btnIngresar")!= null)
		 {
			 int usuario = Integer.parseInt(request.getParameter("txtUsuario"));
			 String clave = request.getParameter("txtClave");
			 

			 verificacion = usuarioDao.verificarUsuario(usuario,clave);
			 if (verificacion==true)
			 {
				 x = clienteDao.obtenerCliente(usuario);
				 nombreUsuario=(x.getNombre()+" "+x.getApellido());
				 y = usuarioDao.obtenerUsuario(usuario);
				 tipoUsuario = y.getTipoUsuario();
				// si es 1 es admin, si es 2 es cliente
				// HttpSession session = request.getSession();
				 request.getSession().setAttribute("usuarioLogeado",nombreUsuario);
				 request.getSession().setAttribute("dniLogeado", usuario);
				 if(tipoUsuario==1)
				 {
				 rd = request.getRequestDispatcher("InicioAdmin.jsp");
				 }
				 else
				 {
					 rd = request.getRequestDispatcher("InicioCliente.jsp");
				 }
			 }
			 else
			 {
				 rd = request.getRequestDispatcher("Login.jsp");
			 }
			 
		 }
		 
		 request.setAttribute("encontroUsuario",verificacion);
		 rd.forward(request, response);
		
		//doGet(request, response);
	}

}
