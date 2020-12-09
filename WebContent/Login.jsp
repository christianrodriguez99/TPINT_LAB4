<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="daoImpl.UsuarioDaoImpl" %>
  <%@page import="Models.Usuario" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>

<h1 class="text-center">Bienvenido</h1>
<form method="post" action="servletUsuario" id="form" style=margin:10px;>
Ingrese su usuario: <input type="text" name="txtUsuario"  class="form-control" /> </br>
Ingrese su clave: <input type="password" name="txtClave"  class="form-control" /> </br>
<input type="submit" name="btnIngresar" value="Ingresar" class="btn btn-dark" onClick="cambiarFormAction()"/>
</form>

<%

    boolean ingresar;
	if (request.getAttribute("encontroUsuario")!=null)
	{
	ingresar =	Boolean.parseBoolean(request.getAttribute("encontroUsuario").toString());
	
	if(ingresar == false)
	{
		
		%>
		</br>
		<div class="alert alert-warning" role="alert" >
		  Usuario y/o contraseña incorrecto/s.
		</div>
		<%
	}
	
	
	}
%>

<script type="text/javascript">

	function cambiarFormAction()
	{
	var frm = document.getElementById('form');			
	if(frm.action!='/TPINT/servletUsuario')
		{
	frm.action = '/TPINT/servletUsuario';	
		}
	
	
	}
	</script>


</body>

</html>