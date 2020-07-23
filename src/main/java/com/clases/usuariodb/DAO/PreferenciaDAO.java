/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clases.usuariodb.DAO;

import com.clases.usuariodb.modelos.Preferencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PreferenciaDAO extends Conexion {

    public ArrayList<Preferencia> listar() {
        ArrayList<Preferencia> usuarios = new ArrayList();

        try (Connection connection = connectToDB()) {
            String query = "SELECT * FROM preferencia"; //sentencia
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Preferencia pref = new Preferencia(
                        Integer.valueOf(rs.getString("id")),
                        rs.getString("descripcion")
                );
                usuarios.add(pref);
            }
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
            // TODO: handle exception
        }
        return usuarios;
    }

    public Preferencia listarById(int id) {
        Preferencia pref = new Preferencia();
        try (Connection connection = connectToDB()) {
            PreparedStatement ps = null;
            String query = "SELECT * FROM preferencia where id = ?"; //sentencia
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ps.setInt(1, id);

            pref = new Preferencia(
                    Integer.valueOf(rs.getString("id")),
                    rs.getString("descripcion"));

            return pref;
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
            // TODO: handle exception
            return null;
        }

    }

    //Guardar un nuevo usuario
    public void insertarPreferencia(Preferencia preferencia) {
        try (Connection connection = connectToDB()) {
            PreparedStatement ps = null;
            //Statement statement = connection.createStatement();
            String query = "insert into preferencia (descripcion) values (?)";
            ps = connection.prepareStatement(query);
            ps.setString(1, preferencia.getDescripcion());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar pref");
            e.printStackTrace();
        }
    }

    //Actualizar  un usuario
    public void actualizarUsuario(Preferencia preferencia) {
        try (Connection connection = connectToDB()) {
            PreparedStatement ps = null;
            //Statement statement = connection.createStatement();
            String query = "update preferencia set descripcion = ? where id =?"; //ojo no olvidarsse del where
            ps = connection.prepareStatement(query);
            ps.setString(1, preferencia.getDescripcion());
            ps.setInt(3, preferencia.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error:" + e.getMessage());
            //estos errores guardar ennun archivo
        }
    }
    //Eliminar  un usuario

    public void eliminarUsuario(int id) {
        try (Connection connection = connectToDB()) {
            PreparedStatement ps = null;
            //Statement statement = connection.createStatement();
            String query = "delete from prefencia where id =? ";///ojo con el where
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
