<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="daoImpl.CuentasDaoImpl" %>
<%@page import="Models.CuentasPorClientes" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<%@page import="Models.Cuentas" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<link href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css" rel="stylesheet" />
<body>
<jsp:include page="MenuCliente.html"/>
<h1>Solicitar prestamo</h1> <br>
Ingrese los datos correspondiente para el nuevo registro:

<form action="servletPrestamo" method="post" style=margin:10px;>

Cantidad a solicitar: <input type="text" name="txtCantidad" class="form-control"><br>

Cantidad de cuotas a pagar: <select name="txtCuotas" class="form-control" >
    			<option>1</option>
    			<option>3</option>
    			<option>6</option>
    			<option>12</option>
    			<option>18</option>
			  </select><br>
			  
			  Asignar a cuenta numero: 

<select id="ClienteCuenta" name="ClientesCuenta">
       
       
       <% 
ArrayList<CuentasPorClientes> Lista = null;
 
       CuentasDaoImpl Seg1 = new CuentasDaoImpl();
       int dni = (Integer)session.getAttribute("dniLogeado");
       Lista = Seg1.obtenerCuentasxCliente(dni);
	
	 
	
%>
<%
if(Lista != null)
for (CuentasPorClientes Lis1 : Lista)
{

%>

<option> <%=Lis1.getNumCuenta() %>   </option>     

<%
}
%>

    </select> 
			  

<input type="submit" name="btnSolicitar" value="Solicitar" class="btn btn-dark">
</form>


<%
	boolean registroExitoso = false;
	if(request.getAttribute("registro") != null)
	{
		registroExitoso = Boolean.parseBoolean(request.getAttribute("registro").toString());
	
	if(registroExitoso==true)
	{
	%>
		 
		</br>
		<div class="alert alert-warning" role="alert" >
		  Prestamo solicitado correctamente.
		</div>		
	<%
	}
	else
	{
		%>
		</br>
		<div class="alert alert-warning" role="alert" >
		  Faltan cargar datos!.
		</div>	
		<%
	}
	}
%>


</body>
</html>