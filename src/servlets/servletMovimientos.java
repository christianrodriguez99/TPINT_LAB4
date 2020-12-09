package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Cliente;
import Models.Movimientos;
import Models.Prestamos;
import daoImpl.ClienteDaoImpl;
import daoImpl.MovimientosDaoImpl;
import daoImpl.PrestamosDaoImpl;

/**
 * Servlet implementation class servletMovimientos
 */
@WebServlet("/servletMovimientos")
public class servletMovimientos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletMovimientos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(request.getParameter("btnMostrarMovimientos") != null)
		{
			MovimientosDaoImpl movimientosDao = new MovimientosDaoImpl();
			ArrayList<Movimientos> lista = movimientosDao.obtenerMovimientos((Integer)request.getSession().getAttribute("dniLogeado"));
			
			request.setAttribute("listaM", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("ListarMovimientos.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
