
package com.emergentes.controlador;

import com.emergentes.dao.ClienteDAO;
import com.emergentes.dao.ClienteDAoimpl;
import com.emergentes.dao.ProductoDAO;
import com.emergentes.dao.ProductoDAOimpl;
import com.emergentes.dao.VentaDAO;
import com.emergentes.dao.VentaDAOimpl;
import com.emergentes.modelo.Cliente;
import com.emergentes.modelo.Producto;
import com.emergentes.modelo.Venta;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VentaControlador", urlPatterns = {"/VentaControlador"})
public class VentaControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            
            int id;
            VentaDAO dao= new VentaDAOimpl();
            ProductoDAO daoproducto = new ProductoDAOimpl();
            ClienteDAO daocliente = new ClienteDAoimpl();
            List<Producto> lista_producto = null;
            List<Cliente> lista_cliente =null;
            Venta v= new Venta();
            String action = (request.getParameter("action")!=null)? request.getParameter("action"): "view";
            switch(action){
                case "add":
                    lista_producto=daoproducto.getAll();
                    lista_cliente=daocliente.getAll();
                    request.setAttribute("lista_p", lista_producto);
                    request.setAttribute("lista_c", lista_cliente);
                    request.setAttribute("venta", v);
                    request.getRequestDispatcher("fmrventa.jsp").forward(request, response);
                    break;
                case "edit":
                    id=Integer.parseInt(request.getParameter("id"));
                    lista_producto=daoproducto.getAll();
                    lista_cliente=daocliente.getAll();
                    v=dao.getById(id);
                    request.setAttribute("lista_p", lista_producto);
                    request.setAttribute("lista_c", lista_cliente);
                    request.setAttribute("venta", v);
                    request.getRequestDispatcher("fmrventa.jsp").forward(request, response);
                    break;
                case "delete":
                    id=Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("VentaControlador");
                    break;
                case "view":
                    List<Venta> lista=dao.getAll();      
                    request.setAttribute("ventas",lista);
                    request.getRequestDispatcher("ventas.jsp").forward(request, response);
                    break;
                    
            }
            
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            int cliente_id = Integer.parseInt(request.getParameter("cliente_id"));
            int producto_id = Integer.parseInt(request.getParameter("producto_id"));
            String fecha = request.getParameter("fecha");
            
            Venta venta= new Venta();
            venta.setId(id);
            venta.setCliente_id(cliente_id);
            venta.setProducto_id(producto_id);
            venta.setFecha(convierteFecha(fecha));
            
            if(id==0){
                VentaDAO dao= new VentaDAOimpl();
                try {
                    dao.insert(venta);
                    response.sendRedirect("VentaControlador");
                } catch (Exception ex) {
                    Logger.getLogger(VentaControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            else{
                VentaDAO dao= new VentaDAOimpl();
                try {
                    dao.update(venta);
                    response.sendRedirect("VentaControlador");
                } catch (Exception ex) {
                    Logger.getLogger(VentaControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
    }
    public Date convierteFecha(String fecha){
                Date fechaBD=null;
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date fechaTMP;
                try {
                    fechaTMP=formato.parse(fecha);
                    fechaBD=new Date (fechaTMP.getTime());
                    
        } catch (Exception e) {
        }
        return fechaBD;        
    }
}
