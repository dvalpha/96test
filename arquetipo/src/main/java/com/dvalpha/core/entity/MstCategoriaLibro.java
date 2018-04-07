package com.dvalpha.core.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "mst_categoria_libro")
public class MstCategoriaLibro extends GenericEntity implements Serializable{


private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	
	@Column(name = "titulo" )
	private String titulo;
	
	
		 
	/**
	 * Una categoria debe tener un libro asociado
	 * Como tenemos un libro asociado le indicamos que nos lo traiga siempre  FetchType.EAGER
	 * Este campo (name=libro) esta asociado con el campo id de la tabla libro (por que el campo es un libro)
	 * @JoinColumn(name = "libro"-->nuestro campo en MstCategoriaLibro,referencedColumnName = "id" de la tabla MstLibro) 
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "libro",referencedColumnName = "id") 
	private MstLibro libro;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="categoria",cascade=CascadeType.ALL)
	List<MstDocumento> documentos;

	
	
	
	
	public List<MstDocumento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<MstDocumento> documentos) {
		this.documentos = documentos;
	}

	public MstLibro getLibro() {
		return libro;
	}

	public void setLibro(MstLibro libro) {
		this.libro = libro;
	}

	public MstCategoriaLibro() {
	}

	public MstCategoriaLibro(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
