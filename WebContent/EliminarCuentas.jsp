<%@page import="daoImpl.CuentasDaoImpl" %>
<%@page import="Models.CuentasPorClientes" %>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="Admin.css">
<title>Insert title here</title>



<style type="text/css"> 

 *
 {
 padding:0px;
 margin:0px;
 }

 

ul, ol {
list-style:none;
}
</style>


 <style type="text/css">
        th,td {
            padding: 0.4rem !important;
        }
        .container {
            box-shadow: 10px 10px 8px #888888;
            border: 2px solid black;
            border-radius: 10px;
        }
    </style>


</head>
<body>
<jsp:include page="MenuAdmin.html"></jsp:include>


<form action="servletCuentas" method="post">  
<input type="submit" name="MuestraCuenta" Value="Mostrar cuentas"  class="btn btn-dark">  
</form>




 
<div class="container" style="margin-top: 25px;padding: 10px"> 

<table id="tablax" class="table table-striped table-bordered" style="width:100%" border=3>
<thead>
<tr> <th> DNI Cliente </th> <th> Nombre </th> <th> Apellido </th> <th> Número de Cuenta </th> <th> Tipo de cuenta </th> <th> Saldo Actual </th>  <th> Eliminar Cuenta </th>   </tr>
 </thead>
<%

ArrayList<CuentasPorClientes> Lista = null;

if(request.getAttribute("ListaCC") != null)
{
	Lista = (ArrayList)request.getAttribute("ListaCC");
}


 
if(Lista != null)
for (CuentasPorClientes Seg : Lista)
{

%>

  <tbody>

<tr> 

<form action="servletCuentas" method="post">  
<td> <%= Seg.getDni() %>   </td>      
 <td> <%= Seg.getNombre() %></td>     
 <td><%= Seg.getApellido() %></td>      
 <td><%=Seg.getNumCuenta() %> <input type="hidden" name="NumCuentaUsu" value="<%=Seg.getNumCuenta() %>" > </td>      
 <td><%=Seg.getTipoCuenta() %> </td>
 <td><%=Seg.getSaldo() %> </td> 
 <td> <input type="submit" name="BtnElimina" value="Eliminar" class="btn btn-dark"> </td>
 </form>
 
              </tr>
 </tbody>

<%
}
%>


</table>

</div>






</body>
</html>