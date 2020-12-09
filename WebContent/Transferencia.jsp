<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
               <%@page import="java.util.ArrayList" %>
    <%@page import="Models.Prestamos" %>
        <%@page import="daoImpl.CuentasDaoImpl" %>
<%@page import="Models.CuentasPorClientes" %>
<%@page import="Models.Cuentas" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>

<jsp:include page="MenuCliente.html"></jsp:include>

<h1>Transferencia por cbu</h1> <br>
Ingrese los datos correspondiente para el nuevo registro:

<form action="servletTransferencias" method="post" style=margin:10px;>


Cuenta a utilizar:
  <select id="ClienteCuenta" name="ClientesCuenta" class="form-control">
       
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
    
CBU a transferir: <input type="text" name="txtCbu" class="form-control" >
Cantidad: <input type="text" name="txtCantidad" class="form-control" > <br>
<input type="submit" name="btnTransferir" value="Transferir" class="btn btn-dark">
</form>

<br>

<%
boolean verificacion=false;
 if (request.getAttribute("estadoSaldo") != null)
 {
	 verificacion = Boolean.parseBoolean( request.getAttribute("estadoSaldo").toString());
	  
	  if(verificacion==false){
		 %>
		<div class="alert alert-danger" role="alert">
	  !Atención! no tienes suficiente saldo para realizar la transferencia!
		</div>
		
		 <%  
	 	}
	 
	
 }
%>

<%
int verificacioncbu=0;
 if (request.getAttribute("estadoCbu") != null)
 {
	 verificacioncbu = Integer.parseInt( request.getAttribute("estadoCbu").toString());
	  
	  if(verificacioncbu==0){
		 %>
		<div class="alert alert-danger" role="alert">
	  !Atención! el cbu es inexistente.
		</div>
		
		 <%  
	 	}
	
 }
%>
<% 
if (request.getAttribute("estadoCbu") != null)
{
	verificacioncbu = Integer.parseInt( request.getAttribute("estadoCbu").toString());
	 if (request.getAttribute("estadoSaldo") != null)
	 {
		 verificacion = Boolean.parseBoolean( request.getAttribute("estadoSaldo").toString());
		 	if(verificacion==true&&verificacioncbu!=0)
		 	{
		  %>
		  <div class="alert alert-success" role="alert">
	    	Transferencia realizada con exito!
			</div>
		  <% 
	  }
	 }
}
		  
%>

</body>
</html>