package controladora;

import java.util.Vector;

import modelo.Boleto;
import capaDAL.*;

public class Controller {
	/**
	 * Método que recupera un listado de todos lso boletos sin diferenciación de sorteo
	 * @return un listado de boletos
	 */
	public Vector<Boleto> listaBoletos(){
		Listados listaDAL=new Listados();
		return listaDAL.listaBoletos(); 
	}
	
	public int insertaBoleto(Boleto boleto){
		BoletoCRUD crud=new BoletoCRUD();
		return crud.insertaBoleto(boleto);
	}
}
