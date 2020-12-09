<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %>
    <%@page import="Models.Prestamos" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="MenuCliente.html"/>

<form method="get" action="servletPrestamo">
<input type="submit" name="btnMostrarPrestamos" value="Mostrar prestamos"  class="btn btn-dark">
</form>

<%	
	ArrayList<Prestamos> listaPrestamos =null;
	if(request.getAttribute("listaP")!=null)
	{
		listaPrestamos = (ArrayList<Prestamos>) request.getAttribute("listaP");
	}
%>

<table class="table table-dark table-striped">
<tr>	<th>ID</th> <th>Numero de cuenta</th> <th>Importe solicitado</th> <th>Fecha</th> <th>Estado</th> <th>Cuotas</th> </tr>
	<% 
	if(listaPrestamos!=null)
	for(Prestamos prestamo : listaPrestamos) 	
	{
	%>
<tr>		<td><%=prestamo.getId() %> </td>  <td><%=prestamo.getNroCuenta() %></td>   <td><%=prestamo.getImportePedido() %></td>     <td><%=prestamo.getFecha() %></td>      <td><%=prestamo.getEstado() %></td>       <td><%=prestamo.getCuotasRestantes() %></td> </tr>
	<% } %>
</table>

</body>
</html>

