package com.dvalpha.core.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "def_departamentos")
public class DefDepartamentos implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre" )
	private String nombre;
	@Lob
	@Column(name = "descripcion" )
	private String descripcion;
	
	@LazyCollection(LazyCollectionOption.FALSE) 
	@OneToMany(mappedBy="defdepartamentos",cascade=CascadeType.ALL) 
	List<MstUsuario> usuarios;

	
	public DefDepartamentos() {}
	
	public DefDepartamentos(Long id) {
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

	public List<MstUsuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<MstUsuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
}
