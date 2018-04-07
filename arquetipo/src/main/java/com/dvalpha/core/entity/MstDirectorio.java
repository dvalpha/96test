package com.dvalpha.core.entity;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "mst_directorio")
public class MstDirectorio extends GenericEntity implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre" )
	private String nombre;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="directorio",cascade=CascadeType.ALL)
	public List <MstArchivo> archivos;
	
	@Column(name = "root" )
	private boolean root;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usuario",referencedColumnName = "id") 
	private MstUsuario usuario;
	

	public List<MstArchivo> getArchivos() {
		return archivos;
	}

	public List<MstArchivo> getArchivosByUser(MstUsuario user) {
		List<MstArchivo> files= new ArrayList();
		for(MstArchivo file:archivos) {
			if(file.getUsuario().getId().equals(user.getId())) {
				files.add(file);
			}	
		}
		return files;
	}
	public void setArchivos(List<MstArchivo> archivos) {
		this.archivos = archivos;
	}

	public MstUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(MstUsuario usuario) {
		this.usuario = usuario;
	}

	public boolean getRoot() {
		return root;
	}

	public void setRoot(boolean root) {
		this.root = root;
	}

	public MstDirectorio() {
		super();
	}

	public MstDirectorio(Long id) {
		super();
		this.id = id;
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
	
	
	
	

}
