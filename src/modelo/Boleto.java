package modelo;
/************
* Propiedades
* ***********
* Basicas:
* idBoleto long, consultable y modificable
* idSorteo long, consultable y modificable
* reintegro short,consultable y modificable
* tipoApuesta short,consultable y modificable
* premio BigDecimal,consultable y modificable
* 
* Restricciones:
* IdBoleto e idSorteo mayor que 0
* Reintegro entre 0 y 9
* TipoApuesta entre 5 y 11 ambos inclusive
* Premio mayor qeu 0
*/

import java.math.BigDecimal;

public class Boleto {
	private long idBoleto;
	private long idSorteo;
	private short reintegro;
	private short tipoApuesta;
	private BigDecimal premio;
	
	
	
	public Boleto() {
		idBoleto=0;
		idSorteo=0;
		reintegro=0;
		tipoApuesta=6;
		premio=new BigDecimal(0);
	}



	public Boleto(long idBoleto, long idSorteo, short reintegro, short tipoApuesta, BigDecimal premio) {
		this.idBoleto = idBoleto;
		this.idSorteo = idSorteo;
		this.reintegro = reintegro;
		this.tipoApuesta = tipoApuesta;
		this.premio = premio;
	}



	/**
	 * @return the idBoleto
	 */
	public long getIdBoleto() {
		return idBoleto;
	}



	/**
	 * @param idBoleto the idBoleto to set
	 */
	public void setIdBoleto(long idBoleto) {
		this.idBoleto = idBoleto;
	}



	/**
	 * @return the idSorteo
	 */
	public long getIdSorteo() {
		return idSorteo;
	}



	/**
	 * @param idSorteo the idSorteo to set
	 */
	public void setIdSorteo(long idSorteo) {
		this.idSorteo = idSorteo;
	}



	/**
	 * @return the reintegro
	 */
	public short getReintegro() {
		return reintegro;
	}



	/**
	 * @param reintegro the reintegro to set
	 */
	public void setReintegro(short reintegro) {
		this.reintegro = reintegro;
	}



	/**
	 * @return the tipoApuesta
	 */
	public short getTipoApuesta() {
		return tipoApuesta;
	}



	/**
	 * @param tipoApuesta the tipoApuesta to set
	 */
	public void setTipoApuesta(short tipoApuesta) {
		this.tipoApuesta = tipoApuesta;
	}



	/**
	 * @return the premio
	 */
	public BigDecimal getPremio() {
		return premio;
	}



	/**
	 * @param premio the premio to set
	 */
	public void setPremio(BigDecimal premio) {
		this.premio = premio;
	}
	
	
}
