<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Models.Cliente" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="MenuCliente.html"/>
<form method="get" action="servletCliente">
<input type="submit" name="btnMisDatos" value="Mostrar mis datos"  class="btn btn-dark">
</form>

<%	
	Cliente cliente = new Cliente();
	if(request.getAttribute("clienteLogeado")!=null)
	{
		cliente = ((Cliente) request.getAttribute("clienteLogeado"));
	}
%>

<table class="table table-dark table-striped">

<% 
	if(cliente.getNombre()!=null)
	
	{
	%>
<tr>	<th>Nombre</th> <th>Apellido</th> <th>E-mail</th> <th>Fecha de nacimiento</th> <th>Nacionalidad</th> <th>Direccion</th> <th>Localidad</th> <th>Provincia</th> <th>Cuil</th> </tr>

<tr>	<td><%=cliente.getNombre()%></td>  <td><%=cliente.getApellido() %></td>   <td><%=cliente.getMail() %></td>   <td><%=cliente.getFechaNac() %></td>      <td><%=cliente.getNacionalidad() %></td>       <td><%=cliente.getDireccion() %></td> <td><%=cliente.getLocalidad() %></td> <td><%=cliente.getProvincia() %></td><td><%=cliente.getCuil() %></td>  </tr>

<%
		}
	%>
</table>

</body>
</html>
</body>
</html>