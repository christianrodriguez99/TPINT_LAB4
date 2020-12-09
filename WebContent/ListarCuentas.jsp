<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@page import="java.util.ArrayList" %>
    <%@page import="Models.Cuentas" %>
     <%@page import="Models.CuentasPorClientes" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
<jsp:include page="MenuCliente.html"/>


<form method="get" action="servletCuentas">
<input type="submit" name="btnMostrarCuentas" value="Mostrar cuentas" class="btn btn-dark">
</form>

<%	
	ArrayList<CuentasPorClientes> listaCuentas =null;
	if(request.getAttribute("listaC")!=null)
	{
		listaCuentas = (ArrayList<CuentasPorClientes>) request.getAttribute("listaC");
	}
%>

<table class="table table-dark table-striped">
<tr>	<th>Numero de cuenta</th> <th>Tipo de cuenta</th> <th>Fecha de creacion</th> <th>CBU</th> <th>Saldo</th>  </tr>
	<% 
	if(listaCuentas!=null)
	for(CuentasPorClientes cuenta : listaCuentas) 	
	{
	%>
<tr>		<td> <%=cuenta.getNumCuenta()%> </td>  <td><%=cuenta.getTipoCuenta() %></td>   <td><%=cuenta.getFechaCreacion() %></td>     <td><%=cuenta.getCbu() %></td>      <td><%=cuenta.getSaldo()%></td>   </tr>
	<% } %>
</table>

</body>
</html>

	