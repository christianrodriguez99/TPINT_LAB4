<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
           <%@page import="java.util.ArrayList" %>
    <%@page import="Models.Movimientos" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>

<jsp:include page="MenuCliente.html"/>

<form method="get" action="servletMovimientos">
<input type="submit" name="btnMostrarMovimientos" value="Mostrar movimientos" class="btn btn-dark">
</form>

<%	
	ArrayList<Movimientos> listaMovimientos =null;
	if(request.getAttribute("listaM")!=null)
	{
		listaMovimientos = (ArrayList<Movimientos>) request.getAttribute("listaM");
	}
%>

<table class="table table-dark table-striped">
<tr>	<th>Numero de cuenta</th> <th>Concepto</th> <th>Fecha</th> <th>Importe</th>  </tr>
	<% 
	if(listaMovimientos!=null)
	for(Movimientos movimiento : listaMovimientos) 	
	{
	%>
<tr><td> <%=movimiento.getNroCuenta()%> </td>  <td><%=movimiento.getConcepto() %></td>  <td><%=movimiento.getFecha() %></td>     <td><%=movimiento.getImporte() %></td>      </tr>
	<% } %>
</table>

</body>
</html>