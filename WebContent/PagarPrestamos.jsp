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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="MenuCliente.html"/>

<form method="get" action="servletPrestamo">
<input type="submit" name="btnMostrarPrestamosAceptados" value="Mostrar prestamos"  class="btn btn-dark">
</form>

<%	
	ArrayList<Prestamos> listaPrestamos =null;
	if(request.getAttribute("listaP")!=null)
	{
		listaPrestamos = (ArrayList<Prestamos>) request.getAttribute("listaP");
	}
%>
<form method="post" action="servletPrestamo" style=margin:10px;>

<div class="container" >
  <div class="row">
    <div class="col-12">
      <table class="table table-bordered">
        <thead>
          <tr>
            <th scope="col">ID</th>
            <th scope="col">Numero de cuenta</th>
            <th scope="col">Importe solicitado</th>
            <th scope="col">Importe que falta pagar</th>
            <th scope="col">Fecha</th>
            <th scope="col">Cuotas Restantes</th>
            <th scope="col">Cuotas Totales</th>
            <th scope="col">Valor por cuota</th>
            <th scope="col">Acciones</th>
          </tr>
        </thead>
        <tbody>
      <%   if(listaPrestamos!=null)
	for(Prestamos prestamo : listaPrestamos) 	
	{ %>
          <tr>
            <th scope="row"><%=prestamo.getId() %> <input type="hidden" name="idPrestamoUsu" value="<%=prestamo.getId() %>" ></th>
            <td><%=prestamo.getNroCuenta() %></td>
            <td><%=prestamo.getImportePedido() %></td>
            <td><%=prestamo.getImporteAPagar() %></td>
            <td><%=prestamo.getFecha() %> </td>
            <td><%=prestamo.getCuotasRestantes() %> </td>
             <td><%=prestamo.getCuotasTotales() %> </td>
              <td><%=prestamo.getImportePedido()/prestamo.getCuotasTotales() %> </td>
            
    
            <td>
              <input type="submit" class="btn btn-success" value="Pagar" name="btnPagar">     
            </td>
          </tr>
         <%
			}
         %>

        </tbody>
      </table>
    </div>
  </div>
  <h4> Cuenta a usar para el pago:</h4>
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
    
      <h4> Cantidad de cuotas a pagar:</h4>
      <select name="txtCuotas" class="form-control" >
    			<option>1</option>
    			<option>3</option>
    			<option>6</option>
    			<option>12</option>
    			<option>18</option>
			  </select><br>
</div>

<%
boolean verificacion=false;
 if (request.getAttribute("estadoSaldo") != null)
 {
	 verificacion = Boolean.parseBoolean( request.getAttribute("estadoSaldo").toString());
	  
	  if(verificacion==false){
		 %>
		<div class="alert alert-danger" role="alert">
	  !Atención! no tienes suficiente saldo o seleccionaste mas cuotas de las disponibles para el pago!
		</div>
		
		 <%  
	 	}
	  else
	  {
		  %>
		  <div class="alert alert-success" role="alert">
	   Pago realizado con exito!
		</div>
		  <% 
	  }
	
 }
%>

</form>
</body>
</html>