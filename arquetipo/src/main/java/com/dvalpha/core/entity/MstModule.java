package com.dvalpha.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mst_module")
public class MstModule extends GenericEntity implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre" )
	private String nombre;
	
	@Column(name = "level" )
	private Integer level;
	
	@Column(name = "rol_id")
	private Long rol_id; //aqui es donde apunta la relacion OneToMany de MstRol 
	
	public MstModule() {}
	public MstModule(Long id) {
		this.id=id;
	}

	@Override
	public String toString() {
		return "MstModule [id=" + id + ", nombre=" + nombre + ", level=" + level + ", rol_id=" + rol_id + "]";
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRol_id() {
		return rol_id;
	}

	public void setRol_id(Long rol_id) {
		this.rol_id = rol_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	
	
	
}
