package com.clases.usuariodb.DAO;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
        public Connection connectToDB() {
		Connection connection = null;
		try {
                        // Por favor conectate a la otra base de datos *****ojo
			String host= "ec2-50-19-26-235.compute-1.amazonaws.com";
                        String database = "dfrtg02nfu9ju";
                        String user = "hxjvdlckmiytvx";
                        String password = "46c591a986c57224f901c25f6cf539d047e14420b06cb6810b5671efa9461157";
                        
                        connection = DriverManager.getConnection("jdbc:postgresql://"+host+":5432/"+database,user, password);
			if (connection != null) {
				System.out.println("Se estableció la conexión :)");
		}
		} catch (Exception e) {
			// TODO: handle exception
                        System.out.println("Error al conectar a la base.");
			e.printStackTrace();
		}finally {
			return connection;
		}
		
	}


    
}
