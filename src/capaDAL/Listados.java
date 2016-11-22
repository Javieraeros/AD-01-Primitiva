package capaDAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import modelo.Boleto;

public class Listados {
	/**
	 * Método que devuelve una lista de Boletos.
	 * @return
	 */
	public Vector<Boleto> listaBoletos(){
		Vector<Boleto> devolver=new Vector<Boleto>();
		DbConnexion miConn=DbConnexion.getDbConnexion();
		Statement instruccion;
		ResultSet resultado;
		
		//Volcamos sobre un array todas las columnas de los boletos
		NombresColumnasBoletos[] boletos=NombresColumnasBoletos.values();
		
		String selectLista="Select "+boletos[0]+","+boletos[1]+
				","+boletos[2]+","+boletos[3]+","+boletos[4]+
				" From "+NombresTablas.values()[0];
		
		try {
			miConn.openConnection();
			instruccion=miConn.getConexionBasedeDatos().createStatement();
			resultado=instruccion.executeQuery(selectLista);
			while(resultado.next()){
				//Necesario aquí porque sino el vector se queda con los datos
				//del último boleto añadido
				
				//Intentar cambiar
				Boleto generico=new Boleto();
				generico.setIdSorteo(resultado.getLong(boletos[0].toString()));
				generico.setIdBoleto(resultado.getLong(boletos[1].toString()));
				generico.setReintegro(resultado.getShort(boletos[2].toString()));
				generico.setTipoApuesta(resultado.getShort(boletos[3].toString()));
				generico.setPremio(resultado.getBigDecimal(boletos[4].toString()));
				devolver.add(generico);
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}finally{
			miConn.closeConnection();
		}
		
		return devolver;
	}
}
