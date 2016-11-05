package capaDAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnexion {
	
	private String sourceURL;
	private String usuario;
	private String password;
	private Connection conexionBasedeDatos;
	
	public DbConnexion(){
		// Intentar usar la info en conf.ini
	      sourceURL = "jdbc:sqlserver://primitiva.database.windows.net:1433;database=PrimitivaJavi;";
	      usuario = "prueba";
	      //La única contraseña que me permite azure
	      password = "pr23ueba234.";
	      
		
		
	      //Para mi casa
		  //Necesario activar protocolo TCP/IP!!!!!
	      /*sourceURL="jdbc:sqlserver://localhost";
	      usuario = "prueba";
	      password = "123";*/
	      
	}

	public DbConnexion(String sourceURL, String usuario, String password) {
		super();
		this.sourceURL = sourceURL;
		this.usuario = usuario;
		this.password = password;
	}

	public void openConnection() throws SQLException{
		// Crear una connexión con el DriverManager
	      try {
			conexionBasedeDatos = 
			    DriverManager.getConnection(sourceURL, usuario, password);
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public void closeConnection(){
		try {
			conexionBasedeDatos.close();
		} catch (SQLException e) {
			//no es la mejor opción
			System.out.println(e);
		}
	}
	
	public String getSourceURL() {
		return sourceURL;
	}

	public void setSourceURL(String sourceURL) {
		this.sourceURL = sourceURL;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Connection getConexionBasedeDatos() {
		return conexionBasedeDatos;
	}

	public void setConexionBasedeDatos(Connection conexionBasedeDatos) {
		this.conexionBasedeDatos = conexionBasedeDatos;
	}
}
