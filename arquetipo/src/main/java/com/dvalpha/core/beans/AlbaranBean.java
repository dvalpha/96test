package com.dvalpha.core.beans;

/**
 * Clase que se encarga de almacenar el result set resultado de listar los clientes
 * usando la consulta :
 * select codclient,count(*) as albaranes, nomcli  from mst_clialb group by codclient order by albaranes desc
 * 
 * @author alex
 *
 */
public class AlbaranBean {

	private String codclient;
	private String albaranes;
	private String nomcli;
	private int id;
	
	
	
	

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}





	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}





	/**
	 * @return the codclient
	 */
	public String getCodclient() {
		return codclient;
	}





	/**
	 * @param codclient the codclient to set
	 */
	public void setCodclient(String codclient) {
		this.codclient = codclient;
	}





	/**
	 * @return the albaranes
	 */
	public String getAlbaranes() {
		return albaranes;
	}





	/**
	 * @param albaranes the albaranes to set
	 */
	public void setAlbaranes(String albaranes) {
		this.albaranes = albaranes;
	}





	/**
	 * @return the nomcli
	 */
	public String getNomcli() {
		return nomcli;
	}





	/**
	 * @param nomcli the nomcli to set
	 */
	public void setNomcli(String nomcli) {
		this.nomcli = nomcli;
	}





	@Override
	public String toString() {
		return "AlbaranBean [codclient=" + codclient + ", albaranes=" + albaranes + ", nomcli=" + nomcli + "]";
	}
	
	
	
}
