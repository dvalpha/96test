package com.dvalpha.core.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "mst_centro")
public class MstCentro extends GenericEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	/**
	 * Razon social de la empresa
	 */
	@Column(name = "razon_social")
	private String razonSocial;
	
	/**
	 * Identificador único asignado a este centro
	 */
	@Column(name = "codigo_centro")
    private String codigoCentro;
	
	/**
	 * Identificador unico para la validacion con servicios REST
	 */
	 @Column(name = "apikey")
	 private String apiKey;
	 
	 /**
	  * Nombre comercial
	  */
	 @Column(name = "nombre_comercial")
	 private String nombreComercial;
	 
	
	 /**
	  * Determina si el centro ha sido eliminado de la base de datos (aunque nunca se borre)
	  */
	 @Column(name = "borrado")
	 private Boolean borrado;
	 
	 
	 
	 /**
	  * Nos permite maquetar el backend para cada cliente
	  */
	 @Column(name = "urlcss")
	 private String urlcss;
	    
	 /**
	  * Codificacion de los archivos subidos por los usuarios
	  */
	 @Column(name = "codificar_archivos")
	 private Boolean codificar_archivos;
	 
	 /**
	  * ATRIBUTOS GENERALES
	  * 
	  */
	 
      @Column(name = "direccion")
	  private String direccion;
	    
	  @Column(name = "poblacion")
	  private String poblacion;
	    
	  @Column(name = "provincia")
	  private String provincia;
	    
	  @Column(name = "cp")
	  private String cp;
	    
	  @Column(name = "pais")
	  private String pais;
	    
	  @Column(name = "telefono")
	  private String telefono;
	    
	  @Column(name = "fax")
	  private String fax;
	    
	  @Column(name = "mail")
	  private String mail;
	    
	  @Column(name = "nif_cif")
	  private String nifCif;
	    
	  @Column(name = "persona_contacto")
	  private String personaContacto;
	    
	  @Column(name = "path_logo")
	  private String pathLogo;
	 
	  @Column(name = "filial")
	  private Boolean filial;

	  
	  
	  /**
	   * DEPENDENCIAS
	   */
	//,orphanRemoval=true
	  @LazyCollection(LazyCollectionOption.FALSE)
	  @OneToMany(mappedBy="mstcentro",cascade=CascadeType.ALL)
	  private List<MstUsuario> usuarios = new ArrayList();
	  
	  
	  public MstCentro() {}
	  

	  public MstCentro(Long id0) {
		this.id=id0;
	}

	/**
	   * Getter & Setters
	   **/
	  
	  
	public Long getId() {
		return id;
	}
	
	
	
	public List<MstUsuario> getUsuarios() {
		return usuarios;
	}

	
	
	
	public void setUsuarios(List<MstUsuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getCodigoCentro() {
		return codigoCentro;
	}

	public void setCodigoCentro(String codigoCentro) {
		this.codigoCentro = codigoCentro;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	

	public Boolean getBorrado() {
		return borrado;
	}

	public void setBorrado(Boolean borrado) {
		this.borrado = borrado;
	}

	

	public String getUrlcss() {
		return urlcss;
	}

	public void setUrlcss(String urlcss) {
		this.urlcss = urlcss;
	}

	public Boolean getCodificar_archivos() {
		return codificar_archivos;
	}

	public void setCodificar_archivos(boolean b) {
		this.codificar_archivos = b;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNifCif() {
		return nifCif;
	}

	public void setNifCif(String nifCif) {
		this.nifCif = nifCif;
	}

	public String getPersonaContacto() {
		return personaContacto;
	}

	public void setPersonaContacto(String personaContacto) {
		this.personaContacto = personaContacto;
	}

	public String getPathLogo() {
		return pathLogo;
	}

	public void setPathLogo(String pathLogo) {
		this.pathLogo = pathLogo;
	}

	public Boolean getFilial() {
		return filial;
	}

	public void setFilial(Boolean filial) {
		this.filial = filial;
	}

	@Override
	public String toString() {
		return "MstCentro [id=" + id + ", razonSocial=" + razonSocial + ", codigoCentro=" + codigoCentro + ", apiKey="
				+ apiKey + ", nombreComercial=" + nombreComercial + ", creacion=, borrado=" + borrado
				+ ", urlcss=" + urlcss + ", codificar_archivos=" + codificar_archivos
				+ ", direccion=" + direccion + ", poblacion=" + poblacion + ", provincia=" + provincia + ", cp=" + cp
				+ ", pais=" + pais + ", telefono=" + telefono + ", fax=" + fax + ", mail=" + mail + ", nifCif=" + nifCif
				+ ", personaContacto=" + personaContacto + ", pathLogo=" + pathLogo + ", filial=" + filial
				+ ", usuarios=" + usuarios + "]";
	}
	    
	  
	  
	
	  
	  
	    
}
