package com.dvalpha.core.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "mst_libro")
public class MstLibro extends GenericEntity implements Serializable{


private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	
	@Column(name = "titulo" )
	private String titulo;
	

    
	//Un libro tiene asociada una lista de categorias aunque no en el formulario
   // Cuando se solicite un libro es posible que queramos extraer sus categorias y añadir un documento a esas categorias
	
	
	@LazyCollection(LazyCollectionOption.FALSE) //trae siempre las categorias
	@OneToMany(mappedBy="libro",cascade=CascadeType.ALL) // hace referencia al campo libro de la tabla MstCategoriaLibro
	List<MstCategoriaLibro> categorias;
	
	
	
	
	
	public List<MstCategoriaLibro> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<MstCategoriaLibro> categorias) {
		this.categorias = categorias;
	}
	public  MstLibro() {}
	public  MstLibro(Long id) {
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
	
	
	
}
