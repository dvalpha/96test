package com.dvalpha.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mst_documento")
public class MstDocumento extends GenericEntity implements Serializable{


private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	
	@Column(name = "titulo" )
	private String titulo;
	
	@Lob
	@Column(name = "cuerpo" )
	private String cuerpo;
	
	@Column(name = "autor" )
	private String autor;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoria",referencedColumnName = "id") 
	private MstCategoriaLibro categoria;

	
	
	
	public MstCategoriaLibro getCategoria() {
		return categoria;
	}

	public void setCategoria(MstCategoriaLibro categoria) {
		this.categoria = categoria;
	}

	public MstDocumento() {
		super();
		
	}
	
	public MstDocumento(Long id) {
		this.id=id;
		
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

	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	

}
