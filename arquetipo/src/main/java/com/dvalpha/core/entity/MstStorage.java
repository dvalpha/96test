package com.dvalpha.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "mst_storage")
public class MstStorage extends GenericEntity implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre" )
	private String nombre;
	
	
	@Lob
	@Column(name = "descripcion")
	private String descripcion;
	
	
	@Column(name = "espacio_maximo_mb")
	private int maxMB;
	
	@Lob
	@Column(name = "extensiones")
	private String extensiones;
	
	@Column(name = "multiples_subidas")
	private String multipleUpload;
	
	@Column(name = "subidas_simultaneas")
	private String subidasSimultaneas;

	
	public MstStorage() {}
	
	public MstStorage(Long id) {
		this.id=id;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getMaxMB() {
		return maxMB;
	}

	public void setMaxMB(int maxMB) {
		this.maxMB = maxMB;
	}

	public String getExtensiones() {
		return extensiones;
	}

	public void setExtensiones(String extensiones) {
		this.extensiones = extensiones;
	}

	public String getMultipleUpload() {
		return multipleUpload;
	}

	public void setMultipleUpload(String multipleUpload) {
		this.multipleUpload = multipleUpload;
	}

	public String getSubidasSimultaneas() {
		return subidasSimultaneas;
	}

	public void setSubidasSimultaneas(String subidasSimultaneas) {
		this.subidasSimultaneas = subidasSimultaneas;
	}
	
	
}
