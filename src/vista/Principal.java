package vista;

import modelo.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Vector;

import capaDAL.DbConnexion;
import controladora.*;
public class Principal {

	public static void menu(){
		System.out.println("ATENCIÓN");
		System.out.println("El siguiente programa es con fines de práctica, por lo que la gran mayoría de validaciones");
		System.out.println("No han sido realizadas. Utilice el programa con precacución");
		System.out.println("Besis");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Selecciona una opción: ");
		System.out.println("0.Salir");
		System.out.println("1.Mostrar todos los boletos");
		System.out.println("2.Insertar un boleto con ResultSet");
		System.out.println("3.En construcción");
		System.out.println("4.En construcción");	}
	
	public static void main(String[] args) {
		int opcion;
		Scanner teclado=new Scanner(System.in);
		Controller con=new Controller();
		
		do{
			menu();
			opcion=Integer.valueOf(teclado.nextLine());
		}while (opcion>3 || opcion<0);
		while(opcion!=0){
			switch (opcion){
				case 1:
					Vector<Boleto> boletos=new Vector<>();
					boletos=con.listaBoletos();
					System.out.println("IdSorteo \tIdBoleto \tReintegro \tTipoApuesta \tPremio");
					for(int i=0;i<boletos.size();i++){
						System.out.print(boletos.elementAt(i).getIdSorteo());
						System.out.print("\t"+boletos.elementAt(i).getIdBoleto());
						System.out.print("\t"+boletos.elementAt(i).getReintegro());
						System.out.print("\t"+boletos.elementAt(i).getTipoApuesta());
						System.out.print("\t"+boletos.elementAt(i).getPremio());
						System.out.println();
					}
					break;
				case 2:
					int resultadoInsercion;
					Boleto boleto=new Boleto();
					System.out.println("Inserta el id del Sorteo: ");
					boleto.setIdSorteo(Long.valueOf(teclado.nextLine()));
					
					System.out.println("Inserta el Reintegro");
					boleto.setReintegro(Short.valueOf(teclado.nextLine()));
					
					System.out.println("Inserta el tipo de apuesta");
					boleto.setTipoApuesta(Short.valueOf(teclado.nextLine()));
					
					resultadoInsercion=con.insertaBoleto(boleto);
					switch(resultadoInsercion){
						case 0:
							System.out.println("Algo ha fallado premo");
							break;
						case 1:
							System.out.println("Todo perfe, cabesa");
							break;
					}
					
					break;
			}
			do{
				menu();
				opcion=Integer.valueOf(teclado.nextLine());
			}while (opcion>3 || opcion<0);
		}
		
		
	}

}
