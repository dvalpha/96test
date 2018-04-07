package com.dvalpha.core.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.dvalpha.core.entity.MstCliente;
@Entity
public class MstPedidoGroup {
	Long id;
	String ref;
	MstCliente cliente;
	Date creacion;
	Integer items;
	Double total;
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
	public MstCliente getCliente() {
		return cliente;
	}
	public void setCliente(MstCliente cliente) {
		this.cliente = cliente;
	}
	public Date getCreacion() {
		return creacion;
	}
	public void setCreacion(Date creacion) {
		this.creacion = creacion;
	}
	public Integer getItems() {
		return items;
	}
	public void setItems(Integer items) {
		this.items = items;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
	
}
