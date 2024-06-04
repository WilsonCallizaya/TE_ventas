/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.dao;

import com.emergentes.modelo.Producto;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NASH
 */
public class ProductoDAOimpl extends ConexionBD implements ProductoDAO{

    @Override
    public void insert(Producto producto) throws Exception {
    try {
        this.conectar();
        PreparedStatement ps=this.conn.prepareStatement("insert into productos (nombre,descripcion,precio) values (?,?,?);");
        ps.setString(1,producto.getNombre());
        ps.setString(2,producto.getDescripcion());
        ps.setFloat(3, producto.getPrecio());
        ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }   
    }

    @Override
    public void update(Producto producto) throws Exception {
    try {
        this.conectar();
        PreparedStatement ps=this.conn.prepareStatement("update productos set nombre=?,descripcion=?,precio=? where id=?;");
        ps.setString(1,producto.getNombre());
        ps.setString(2,producto.getDescripcion());
        ps.setFloat(3, producto.getPrecio());
        ps.setInt(4, producto.getId());
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
        PreparedStatement ps=this.conn.prepareStatement("delete from productos where id=?");       
        ps.setInt(1, id);
        ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }  
    }

    @Override
    public Producto getById(int id) throws Exception {
        Producto pro = new Producto();
       try {
        this.conectar();
        PreparedStatement ps=this.conn.prepareStatement("select * from productos where id=?;");       
        ps.setInt(1, id);
        ResultSet rs= ps.executeQuery();
        
        if(rs.next()){
            pro.setId(rs.getInt("id"));
            pro.setNombre(rs.getString("nombre"));
            pro.setDescripcion(rs.getString("descripcion"));
            pro.setPrecio(rs.getFloat("precio"));
                    
        }     
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
       return pro;
    }

    @Override
    public List<Producto> getAll() throws Exception {
        List<Producto> lista=null;
        try {
        this.conectar();
        PreparedStatement ps=this.conn.prepareStatement("select * from productos;");       
        ResultSet rs= ps.executeQuery();
        lista= new ArrayList<Producto>();
        while(rs.next()){
            Producto p= new Producto();
            p.setId(rs.getInt("id"));
            p.setNombre(rs.getString("nombre"));
            p.setDescripcion(rs.getString("descripcion"));
            p.setPrecio(rs.getFloat("precio"));
            lista.add(p);
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
