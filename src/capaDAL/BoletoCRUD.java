package capaDAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.lang.*;

import modelo.Boleto;

public class BoletoCRUD {
	/**
	 * Método de práctica para usar un insert con un resultset
	 * Tal vez no es la opción más viable, pero es para poder practicarlo
	 * @param boleto: El boleto a insertar
	 * @return 1 si el boleto se ha insertado correctaente, 0 en caso contrario
	 */
	public int insertaBoleto(Boleto boleto){
		DbConnexion miConexion=DbConnexion.getDbConnexion();
		int res=1;
		Statement instruccion;
		ResultSet resultado;
		String miSelect="Select max(IdBoleto) from Boletos where IdSorteo="+boleto.getIdSorteo();
		
		String miSelect2="Select IdBoleto,IdSorteo,Reintegro,TipoApuesta from Boletos";
		
		
		try {
			miConexion.openConnection();
			instruccion=miConexion.getConexionBasedeDatos().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			resultado=instruccion.executeQuery(miSelect);
			//Añadimos uno al último de los boletos para nuestro boleto
			if(resultado.next()){
				boleto.setIdBoleto(resultado.getLong(1)+1);
			}
			resultado=instruccion.executeQuery(miSelect2);
			resultado.moveToInsertRow();
			resultado.updateLong("IdBoleto",boleto.getIdBoleto());
			resultado.updateLong("IdSorteo",boleto.getIdSorteo());
			resultado.updateShort("Reintegro",boleto.getReintegro());
			resultado.updateShort("TipoApuesta",boleto.getTipoApuesta());
			resultado.insertRow();
		} catch (SQLException e) {
			System.out.println(e);
			res=0;
		} finally{
			miConexion.closeConnection();
		}
		return res;
		
	}
}
