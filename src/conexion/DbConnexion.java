package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnexion {
	public DbConnexion(){
		// Define the data source for the driver
	      String sourceURL = "jdbc:sqlserver://localhost";
	      String usuario = "pepito";
	      String password = "qq";
	      Connection connexionBaseDatos;
	      
	      
	      // Crear una connexión con el DriverManager
	      try {
			connexionBaseDatos = 
			    DriverManager.getConnection(sourceURL, usuario, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
