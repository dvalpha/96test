package com.dvalpha.core.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name = "mst_proveedor")
public class MstProveedor extends GenericEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "ref" )
	private String ref;
	
	@Column(name = "nombre" )
	private String nombre;
	
	@Column(name = "nif" )
	private String nif;
	
	@Column(name = "mail" )
	private String mail;
	
	@Column(name = "avatar" )
	private String avatar;
	

	@LazyCollection(LazyCollectionOption.FALSE) //trae siempre las categorias
	@OneToMany(mappedBy="proveedor",cascade=CascadeType.ALL) // hace referencia al campo libro de la tabla MstCategoriaLibro
	List<MstProducto> productos;
	
	
	
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

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	

	
	public List<MstProducto> getProductos() {
		return productos;
	}

	public void setProductos(List<MstProducto> productos) {
		this.productos = productos;
	}

	public MstProveedor(Long id) {
		super();
		this.id = id;
	}

	
	public MstProveedor() {}
	
	
}
