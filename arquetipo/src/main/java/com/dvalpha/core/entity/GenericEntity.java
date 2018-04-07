package com.dvalpha.core.entity;



import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass

public class GenericEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
	
	@Column(name = "creacion" )
    private java.util.Date creacion;

	@Column(name = "orden")
    private Integer orden;
	
	@Column(name = "activo")
	private Boolean activo;
	
	@Column(name = "imagen")
	private String imagen;
	
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public java.util.Date getCreacion() {
		creacion = new Date();
		return creacion;
	}

	public void setCreacion(java.util.Date creacion) {
		this.creacion = creacion;
	}

	/*
	@PrePersist
    protected void onCreate() {
		creacion = new Date();
    }

   */

	

	
    
    
    
    
    
}
