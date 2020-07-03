package com.clases.usuariodb;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
        public Connection connectToDB() {
		Connection connection = null;
		try {
			//Class.forName("org.postgresql.Driver");//localhost
			//connection = DriverManager.getConnection("jdbc:postgresql://engicoders:5432/dbusuario","postgres", "postgres");
                        
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbusuario","root", "admin");
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
