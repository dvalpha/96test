package com.dvalpha.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mst_producto ")
public class MstProducto extends GenericEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "ref" )
	private String ref;
	
	@Column(name = "nombre" )
	private String nombre;
	
	@Column(name = "precio" )
	private Double precio;
	
	@Column(name = "stock" )
	private Long stock;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "proveedor",referencedColumnName = "id") 
	private MstProveedor proveedor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	

	

	public MstProveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(MstProveedor mstProveedor) {
		this.proveedor = mstProveedor;
	}

	public MstProducto(Long id) {
		super();
		this.id = id;
	}


	
	public MstProducto() {}
	

}
