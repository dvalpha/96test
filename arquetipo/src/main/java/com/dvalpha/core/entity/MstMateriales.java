package com.dvalpha.core.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mst_materiales")
public class MstMateriales extends GenericEntity implements Serializable{


private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	
	
	
	
	@Column(name = "codigo")
	private Long codigo;
	
	@Column(name = "material" )
	private String material;
	
	@Column(name = "calidad" )
	private String calidad;
	
	@Column(name = "um" )
	private String um;
	
	@Column(name = "precio" )
	private Double precio;
	
	@Column(name = "tipo" )
	private String tipo;
	
	@Column(name = "abm" )
	private String abm;

	public MstMateriales(Long id) {
		super();
		this.id = id;
	}
	
	public MstMateriales() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getCalidad() {
		return calidad;
	}

	public void setCalidad(String calidad) {
		this.calidad = calidad;
	}

	public String getUm() {
		return um;
	}

	public void setUm(String um) {
		this.um = um;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getAbm() {
		return abm;
	}

	public void setAbm(String abm) {
		this.abm = abm;
	}

	
	
	
	
	
	
	
	
	
}
