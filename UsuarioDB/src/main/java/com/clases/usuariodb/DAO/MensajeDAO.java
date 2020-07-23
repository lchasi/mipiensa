/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clases.usuariodb.DAO;

import com.clases.usuariodb.Conexion;
import com.clases.usuariodb.modelos.Mensajes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author magb
 */
public class MensajeDAO extends Conexion{
       public void insertarMensaje(Mensajes mensaje) {
        try (Connection connection = connectToDB()) {
            PreparedStatement ps = null;
            //Statement statement = connection.createStatement();
            String query = "insert into mensajes (mensaje, fecha) values (?,?)";
            ps = connection.prepareStatement(query);
            ps.setString(1, mensaje.getMensaje());
            ps.setString(2, mensaje.getFecha());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
       
     public ArrayList<Mensajes> listar() {
        ArrayList<Mensajes> mensajes = new ArrayList();

        try (Connection connection = connectToDB()) {
            String query = "SELECT * FROM mensajes"; //sentencia
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Mensajes msg = new Mensajes(
                        Integer.valueOf(rs.getString("id")),
                        rs.getString("mensaje"),
                        rs.getString("fecha")
                );
                mensajes.add(msg);
            }
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
            // TODO: handle exception
        }
        return mensajes;
    }
     
         public void eliminarMensaje(int id) {
        try (Connection connection = connectToDB()) {
            PreparedStatement ps = null;
            //Statement statement = connection.createStatement();
            String query = "delete from mensajes where id =? ";///ojo con el where
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
 
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
