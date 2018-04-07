package com.dvalpha.core.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "mst_componente")
public class MstComponente extends GenericEntity implements Serializable{


private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	
	/*@ManyToMany(cascade = { CascadeType.REMOVE },fetch = FetchType.EAGER)
    @JoinTable(
        name = "mst_componente_mst_materiales", 
        joinColumns = { @JoinColumn(name = "materiales_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "componentes_id") }
    )
    private List<MstMateriales> materiales = new ArrayList<MstMateriales>();
    public List<MstMateriales> getMateriales() {
		return materiales;
	}
	public void setMateriales(List<MstMateriales> materiales) {
		this.materiales = materiales;
	}*/

	//@ManyToMany(targetEntity=MstArticulo.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    //private List<MstArticulo> articulos = new ArrayList<MstArticulo>();

	
	
	@Column(name = "codigo" )
	private String codigo;
	@Column(name = "descritipo" )
	private String descritipo;
	
	public MstComponente() {}
	public MstComponente(Long id) {
		this.id=id;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	
	@Override
	public String toString() {
		return "MstComponente [id=" + id + ", codigo=" + codigo + ", descritipo=" + descritipo + "]";
	}
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescritipo() {
		return descritipo;
	}
	public void setDescritipo(String descritipo) {
		this.descritipo = descritipo;
	}
	
	
	
	
	
}
