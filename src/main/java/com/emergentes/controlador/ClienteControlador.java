package com.emergentes.controlador;

import com.emergentes.dao.ClienteDAO;
import com.emergentes.dao.ClienteDAoimpl;
import com.emergentes.modelo.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ClienteControlador", urlPatterns = {"/ClienteControlador"})
public class ClienteControlador extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Cliente cli= new Cliente();
            int id;
            ClienteDAO dao= new ClienteDAoimpl();
            String action = (request.getParameter("action")!=null)? request.getParameter("action"): "view";
            switch(action){
                case "add":
                    request.setAttribute("cliente", cli);
                    request.getRequestDispatcher("frmcliente.jsp").forward(request, response);
                    break;
                case "edit":
                    id=Integer.parseInt(request.getParameter("id"));
                    cli=dao.getById(id);
                    request.setAttribute("cliente", cli);
                    request.getRequestDispatcher("frmcliente.jsp").forward(request, response);
                    break;
                case "delete":
                    id=Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("ClienteControlador");
                    break;
                case "view":
                    List<Cliente> lista=dao.getAll();      
                    request.setAttribute("clientes",lista);
                    request.getRequestDispatcher("clientes.jsp").forward(request, response);
                    break;
                    
            }
            
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        String nombre=request.getParameter("nombre");
        String correo=request.getParameter("correo");
        String celular= request.getParameter("celular"); 
        
        Cliente cli= new Cliente();
        cli.setId(id);
        cli.setNombre(nombre);
        cli.setCorreo(correo);
        cli.setCelular(celular);
        ClienteDAO dao= new ClienteDAoimpl();
        if(id==0){
            try {
                dao.insert(cli);
            } catch (Exception e) {
            }
        }
        else{
            try {
                dao.update(cli);
            } catch (Exception e) {
            }
        }
        response.sendRedirect("ClienteControlador");
    }

}
