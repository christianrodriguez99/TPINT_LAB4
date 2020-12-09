<%@page import="daoImpl.CuentasDaoImpl" %>
<%@page import="Models.CuentasPorClientes" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<%@page import="Models.Cuentas" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<title>Agregar Cuentas</title>
<body>
<jsp:include page="MenuAdmin.html"></jsp:include>
<h1>Agregar Nueva Cuenta a Usuarios.</h1>

<form action="servletCuentas" method="get" style=margin:10px;>


Número de Cuenta:     Se le asignará un número autogenerado.

<br>  <br>  <br>  
Fecha de Creación:    <%= LocalDate.now()  %>
 


<br>  <br>  <br>  

Tipo de Cuenta a Agregar:

<select id="TiposCuenta" name="TiposCuentaCombobox" class="form-control">
       
       
       <% 
ArrayList<Cuentas> Lista1 = null;
 
       CuentasDaoImpl Seg1 = new CuentasDaoImpl();
       Lista1 = Seg1.obtenerTiposCuentas();
	
	 
	
%>
<%
if(Lista1 != null)
for (Cuentas Lis : Lista1)
{

%>

<option> <%=Lis.getDescripcion() %>   </option>     

<%
}
%>

    </select> 




<br>   

Asignar a Cliente (D.N.I): 

<select id="ClienteDNI" name="ClientesDNI" class="form-control">
       
       
       <% 
ArrayList<CuentasPorClientes> Lista = null;
 
       CuentasDaoImpl Seg = new CuentasDaoImpl();
       Lista = Seg1.obtenerDNIClientes();
	
	 
	
%>
<%
if(Lista != null)
for (CuentasPorClientes Lis1 : Lista)
{

%>

<option> <%=Lis1.getDni() %>   </option>     

<%
}
%>

    </select> 


<br>  
<input type="submit" name="btnAceptar" value="Aceptar" class="btn btn-dark" > &nbsp;  &nbsp;&nbsp;

<br> 
<div class="alert alert-light" role="alert">!Atención! la Cuenta inicializará con un Saldo Pre-Definido de $10.000	</div>


</form>

<%
int cuentas=0;
 if (request.getAttribute("maximoAlcanzado") != null)
 {
	 cuentas = Integer.parseInt( request.getAttribute("maximoAlcanzado").toString());
	 
 }
 %>
 <% 
  if(cuentas>=3){
	 %>
	<div class="alert alert-danger" role="alert">
  !Atención! ya existen 3 o mas cuentas asociadas a ese DNI!
	</div>
	 <%  
 	}
%>


 <%int filas=0;
 if (request.getAttribute("CantFilas") != null)
 {
	 filas = Integer.parseInt( request.getAttribute("CantFilas").toString());
 }
  
 
 
 %>
 
 <% if (filas == 1){ %>
 <div class="alert alert-success" role="alert">
 Se agrego el Seguro.
 </div>
 <%} %>


</body>
</html>