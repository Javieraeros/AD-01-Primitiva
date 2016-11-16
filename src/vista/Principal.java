package vista;

import modelo.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import capaDAL.DbConnexion;
import controladora.*;
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<Boleto> boletos=new Vector<>();
		DbConnexion miCone=DbConnexion.getDbConnexion();
		Controller lista=new Controller();
		boletos=lista.listaBoletos();
		Statement instruccion;
		ResultSet resultado;
		
		System.out.println("IdSorteo \tIdBoleto \tReintegro \tTipoApuesta \tPremio");
		for(int i=0;i<boletos.size();i++){
			System.out.print(boletos.elementAt(i).getIdSorteo());
			System.out.print("\t"+boletos.elementAt(i).getIdBoleto());
			System.out.print("\t"+boletos.elementAt(i).getReintegro());
			System.out.print("\t"+boletos.elementAt(i).getTipoApuesta());
			System.out.print("\t"+boletos.elementAt(i).getPremio());
			System.out.println();
		}
		
		
		String conexiones="SELECT login_name ,COUNT(session_id) AS session_count "+
		"FROM sys.dm_exec_sessions "+ 
		"GROUP BY login_name";
		
		try {
			instruccion=miCone.getConexionBasedeDatos().createStatement();
			resultado=instruccion.executeQuery(conexiones);
			resultado.next();
			System.out.println(resultado.getString(1));
		} catch (SQLException e) {
		}
	}

}
