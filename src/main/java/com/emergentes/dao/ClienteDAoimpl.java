
package com.emergentes.dao;

import com.emergentes.modelo.Cliente;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAoimpl extends ConexionBD implements ClienteDAO{

    @Override
    public void insert(Cliente cliente) throws Exception {       
        try {
        this.conectar();
        PreparedStatement ps=this.conn.prepareStatement("insert into clientes (nombre,correo,celular) values (?,?,?);");
        ps.setString(1,cliente.getNombre());
        ps.setString(2,cliente.getCorreo());
        ps.setString(3, cliente.getCelular());
        ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public void update(Cliente cliente) throws Exception {
        try {
        this.conectar();
        PreparedStatement ps=this.conn.prepareStatement("update clientes set nombre=?,correo=?,celular=? where id=?;");
        ps.setString(1,cliente.getNombre());
        ps.setString(2,cliente.getCorreo());
        ps.setString(3, cliente.getCelular());
        ps.setInt(4, cliente.getId());
        ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
        this.conectar();
        PreparedStatement ps=this.conn.prepareStatement("delete from clientes where id=?");       
        ps.setInt(1, id);
        ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public Cliente getById(int id) throws Exception {
        Cliente cli = new Cliente();
        try {
        this.conectar();
        PreparedStatement ps=this.conn.prepareStatement("select * from clientes where id=?;");       
        ps.setInt(1, id);
        ResultSet rs=ps.executeQuery(); 
        if(rs.next()){
            cli.setId(rs.getInt("id"));
            cli.setNombre(rs.getString("nombre"));
            cli.setCorreo(rs.getString("correo"));
            cli.setCelular(rs.getString("celular"));
        }
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
        return cli;
    }

    @Override
    public List<Cliente> getAll() throws Exception {
        List<Cliente> lista=null;
        try {
        this.conectar();
        PreparedStatement ps=this.conn.prepareStatement("select * from clientes;");       
        ResultSet rs=ps.executeQuery(); 
        lista= new ArrayList<Cliente>();
        
        while(rs.next()){
            Cliente cli = new Cliente();
            cli.setId(rs.getInt("id"));
            cli.setNombre(rs.getString("nombre"));
            cli.setCorreo(rs.getString("correo"));
            cli.setCelular(rs.getString("celular"));
            
            lista.add(cli);
        }
        rs.close();
        ps.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
        return lista;
    }
    
}
