<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@page import="java.util.ArrayList" %>
    <%@page import="Models.Prestamos" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<link href="PrestamosCss.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="MenuAdmin.html"/>

<form method="get" action="servletPrestamo">
<input type="submit" name="btnMostrarPrestamosAdmin" value="Mostrar prestamos"  class="btn btn-dark" >
</form>

<%	
	ArrayList<Prestamos> listaPrestamos =null;
	if(request.getAttribute("listaP")!=null)
	{
		listaPrestamos = (ArrayList<Prestamos>) request.getAttribute("listaP");
	}
%>
<form method="post" action="servletPrestamo">

<div class="container" >
  <div class="row">
    <div class="col-12">
      <table class="table table-bordered">
        <thead>
          <tr>
            <th scope="col">ID</th>
            <th scope="col">Numero de cuenta</th>
            <th scope="col">Importe solicitado</th>
            <th scope="col">Fecha</th>
            <th scope="col">Cuotas</th>
            <th scope="col">Acciones</th>
          </tr>
        </thead>
        <tbody>
      <%   if(listaPrestamos!=null)
	for(Prestamos prestamo : listaPrestamos) 	
	{ %>
          <tr>
            <th scope="row"><%=prestamo.getId() %> <input type="hidden" name="idPrestamoUsu" value="<%=prestamo.getId() %>" ></th>
            <td><%=prestamo.getNroCuenta() %> </td>
            <td><%=prestamo.getImportePedido() %></td>
            <td><%=prestamo.getFecha() %></td>
            <td><%=prestamo.getCuotasRestantes() %> </td>
    
            <td>
              <input type="submit" class="btn btn-success" value="Aceptar" name="btnAceptar">
            <input type="submit" class="btn btn-danger" value="Rechazar" name="btnEliminar">
            </td>
          </tr>
         <%
			}
         %>

        </tbody>
      </table>
    </div>
  </div>
</div>

</form>


</body>
</html>