package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Validate extends ConexionBD {

    Connection con = this.conectar();
    PreparedStatement pr;

    public boolean checkUser(String email, String password) {
        boolean resultado = false;
        String sql = "select * from usuarios where email=? and password=sha1(?);";
        try {
            pr = con.prepareStatement(sql);
            pr.setString(1, email);
            pr.setString(2, password);
            ResultSet rs= pr.executeQuery();
            resultado = rs.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(Validate.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }
}
