<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
      <div class="container"> 
          <h1>Formulario Ventas</h1>
          <jsp:include page="WEB-INF/menu.jsp">
              <jsp:param name="opcion" value="ventas"/>
          </jsp:include>
          <form action="VentaControlador" method="post">
              <input type="hidden" name="id" value="${venta.id}">
            <div class="mb-3">
              <label for="" class="form-label">Cliente</label>
              <select name="cliente_id" class="from-control">
                  <option value="">----SELECCIONE----</option> 
                  <c:forEach var="item" items="${lista_c}">
                      <option value="${item.id}" <c:if test="${venta.cliente_id == item.id}">selected
                            </c:if>>${item.nombre}</option> 
                  </c:forEach>
              </select>
              </div>
            
            <div class="mb-3">
              <label for="" class="form-label">Producto</label>
              <select name="producto_id" class="from-control">
                  <option value="">----SELECCIONE----</option> 
              <c:forEach var="item" items="${lista_p}">
                  <option value="${item.id}" <c:if test="${venta.producto_id == item.id}">selected
                            </c:if>
                          >${item.nombre}</option> 
                  </c:forEach>
            </select>
              
            </div>
            <div class="mb-3">
              <label for="" class="form-label">Fecha</label>
              <input type="text" class="form-control" name="fecha" value="${venta.fecha}" placeholder="Escriba la fecha">
            </div>
            <button type="submit" class="btn btn-primary">Enviar</button>
          </form>
      
      </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>