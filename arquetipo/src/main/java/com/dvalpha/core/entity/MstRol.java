package com.dvalpha.core.entity;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "mst_rol")
public class MstRol extends GenericEntity implements Serializable{
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
	
	
     //Un rol tiene muchos modulos
	 @OneToMany(mappedBy="rol_id",cascade=CascadeType.ALL) //en la tabla MODULOS hay un campo llamado rol_id
	 @LazyCollection(LazyCollectionOption.FALSE)
     public List<MstModule> modulos;//tabla modulos
   
   
   
   
    
    public List<MstModule> getModulos() {
		return modulos;
	}
	public void setModulos(List<MstModule> modulos) {
		this.modulos = modulos;
	}
	public MstRol() {}
    public MstRol(Long id) {
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


    
    
    
}
