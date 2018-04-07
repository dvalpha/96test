package com.dvalpha.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "temp")
public class Testxx extends GenericEntity implements Serializable{


private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "id")
private Long id;

@Column(name = "material_id")
private Long idmaterial;

@Column(name = "componente_id")
private Long idcomponente;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Long getIdmaterial() {
	return idmaterial;
}

public void setIdmaterial(Long idmaterial) {
	this.idmaterial = idmaterial;
}

public Long getIdcomponente() {
	return idcomponente;
}

public void setIdcomponente(Long idcomponente) {
	this.idcomponente = idcomponente;
}




}
