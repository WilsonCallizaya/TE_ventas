<%
    if(session.getAttribute("login")!="Ok"){
        response.sendRedirect("login.jsp");
    }
    %>

<%@page import="com.emergentes.modelo.Cliente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Punto de Venta</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" rel="stylesheet">
  </head>
  <body>
      <div class="container"> 
          <h1>Clientes</h1>
          <jsp:include page="WEB-INF/menu.jsp">
              <jsp:param name="opcion" value="clientes"/>
          </jsp:include>
          <a href="Logout" class="btn btn-danger">Cerrar Sesión</a> <br>
      <a href="ClienteControlador?action=add" class="btn btn-primary btn-sm"><i class="fa-solid fa-square-plus"></i>Nuevo</a>
      
      <table class="table table-striped">
          <tr>
              <th>ID</th>
              <th>NOMBRE</th>
              <th>CORREO</th>
              <th>CELULAR</th>
              <th></th>
              <th></th>
          </tr>
          <c:forEach var="item" items="${clientes}">         
          <tr>
              <td>${item.id}</td>
              <td>${item.nombre}</td>
              <td>${item.correo}</td>
              <td>${item.celular}</td>
              <td><a href="ClienteControlador?action=edit&id=${item.id}"><i class="fa-solid fa-pen-to-square"></i></a></td>
              <td><a href="ClienteControlador?action=delete&id=${item.id}" onclick="return(confirm('esta seguro de eliminar'))"><i class="fa-solid fa-trash"></i></a></td>
              
          </tr>
          </c:forEach>
      </table>    
      </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>