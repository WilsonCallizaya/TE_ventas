
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
      <div class="container"> <h1>Punto de Venta</h1>
          <jsp:include page="WEB-INF/menu.jsp">
              <jsp:param name="opcion" value="productos"/>
          </jsp:include>
      <a href="#" class="btn btn-primary btn-sm"><i class="fa-solid fa-square-plus"></i>Nuevo</a>
      
      <table class="table table-striped">
          <tr>
              <th>ID</th>
              <th>NOMBRE</th>
              <th>DESCRIPCION</th>
              <th>PRECIO</th>
              <th></th>
              <th></th>
          </tr>
          <tr>
              <td>1</td>
              <td>2</td>
              <td>3</td>
              <td>4</td>
              <td>5</td>
              <td><a href="#"></a><i class="fa-solid fa-pen-to-square"></i></td>
              <td><a href="#"></a><i class="fa-solid fa-trash"></i></td>
              
          </tr>
      </table>
      
      
      
      
      
      </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>