package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.CuentasDaoImpl;
import daoImpl.PrestamosDaoImpl;
import daoImpl.TransferenciasDaoImpl;

/**
 * Servlet implementation class servletTransferencias
 */
@WebServlet("/servletTransferencias")
public class servletTransferencias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletTransferencias() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnTransferir") != null)
		{
			boolean verificacion = false;
			int verificacioncbu = 0;
			int saldo = 0;
			int CBU = Integer.parseInt( request.getParameter("txtCbu"));
		 	int nroCuenta = (Integer.parseInt(request.getParameter("ClientesCuenta")));
		 	int importe = (Integer.parseInt(request.getParameter("txtCantidad")));
		 	
			TransferenciasDaoImpl td = new TransferenciasDaoImpl();		
			CuentasDaoImpl cd = new CuentasDaoImpl();
			
			verificacioncbu = td.verificarCbu(CBU);
			saldo = cd.obtenerSaldoCuentaPornroCuenta(nroCuenta);
			
			if(verificacioncbu!=CBU)
			{
			verificacioncbu=0;
			}

			if(saldo>=importe) {		
				verificacion = true;
			}
			if(saldo>=importe&&verificacioncbu!=0)
			{
				td.generarTransferencia(CBU,importe,nroCuenta);
			}
			
			request.setAttribute("estadoCbu", verificacioncbu);
			request.setAttribute("estadoSaldo", verificacion);
			RequestDispatcher rd = request.getRequestDispatcher("Transferencia.jsp");   
	        rd.forward(request, response);
			doGet(request, response);
			 
		}
		doGet(request, response);
	}

}
