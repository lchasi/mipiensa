/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clases.usuariodb.DAO;

import com.clases.usuariodb.modelos.Preferencia;
import com.clases.usuariodb.modelos.Pregunta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PreguntaDAO extends Conexion {

    public ArrayList<Pregunta> listar() {
        ArrayList<Pregunta> preguntas = new ArrayList();

        try (Connection connection = connectToDB()) {
            String query = "SELECT * FROM pregunta"; //sentencia
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Pregunta preg = new Pregunta(                   
                        rs.getInt("numero"),
                        rs.getString("pregunta"),
                        rs.getString("ruta"),
                        rs.getInt("respuesta")
                );
                preguntas.add(preg);
            }
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
            // TODO: handle exception
        }
        return preguntas;
    }

}
