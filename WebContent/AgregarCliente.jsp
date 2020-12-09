<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html SYSTEM "about:legacy-compat">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuevo Cliente</title>
</head>
<link href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css" rel="stylesheet" />
<body>
<jsp:include page="MenuAdmin.html"></jsp:include>

<%
	boolean registroExitoso = false;
	if(request.getAttribute("registro") != null)
	{
		registroExitoso = Boolean.parseBoolean(request.getAttribute("registro").toString());
	
	if(registroExitoso==true)
	{
	%>
		 
		</br>
		<div class="alert alert-success" role="alert" >
		  Usuario creado en el sistema correctamente.
		</div>		
	<%
	}
	else
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

Ingrese los datos correspondiente para el nuevo registro:

<form action="servletCliente" method="post" style=margin:10px;>

Nombre: <input type="text" name="txtNombre" class="form-control"><br>
Apellido: <input type="text" name="txtApellido" class="form-control" ><br>
Fecha de Nacimiento: <input type="date" id="fecha" name="dateFechaNac" class="form-control" ><br>
DNI: <input type="text" name="txtDni" class="form-control" ><br>
Cuil: <input type="text" name="txtCuil" class="form-control" ><br>
Sexo:     <p1 style="margin-left:10px; margin-bottom:10px">Hombre</p1> <input type="radio" name="txtSexo" value="Hombre" > 
	  <p1 style="margin-left:20px">Mujer</p1>	 <input type="radio" name="txtSexo" value="Mujer"  >  <br><br>
Direccion: <input type="text" name="txtDireccion" class="form-control" ><br>
Nacionalidad: <select name="txtNacionalidad" class="form-control" >
    			<option>Argentina</option>
    			<option>Chile</option>
    			<option>Colombia</option>
    			<option>España</option>
    			<option>Mexico</option>
    			<option>Paraguay</option>
    			<option>Peru</option>
			  </select><br>
Provincia: <input type="text" name="txtProvincia" class="form-control" ><br>
Localidad: <input type="text" name="txtLocalidad" class="form-control" ><br>
Email: <input type="email" name="txtMail" class="form-control" ><br>
Telefono: <input type="text" name="txtTelefono"class="form-control" > <br>
<br>
<p>Datos del usuario:</p>
<p><u>El nombre del usuario sera igual al DNI.</u></p>
Contraseña del usuario: <input type="text" name="txtContraseña"class="form-control" > <br>
<input type="submit" name="btnIngresar" value="Agregar" class="btn btn-dark">
</form>




</body>
</html>