package capaDAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.lang.*;

import modelo.Boleto;

public class BoletoCRUD {
	public int insertaBoleto(Boleto boleto){
		DbConnexion miConexion=DbConnexion.getDbConnexion();
		
		Statement instruccion;
		ResultSet resultado;
		String miInsert;
		
		try {
			instruccion=miConexion.getConexionBasedeDatos().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		
	}
}
