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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.dvalpha.core.entity.GenericEntity;

@Entity
@Table(name = "mst_pedido")
@NamedQueries({
    @NamedQuery(name = "groupbyref", query = "SELECT m FROM MstPedido m GROUP BY ref")
    
})
public class MstPedido extends GenericEntity implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "ref")
	private String ref;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cliente",referencedColumnName = "id") 
	private MstCliente cliente;
	
	//la relacion con producto es many to many por eso es de tipo long
	@Column(name = "producto")
	private Long producto;
	
	@Column(name = "cantidad")
	private Long cantidad;

	@Column(name = "importe")
	private Double importe;
	
	@Column(name = "items")
	private Integer items;
	
	@Column(name = "total_pedido")
	private Double totalPedido;
	
	
	
	public Double getTotalPedido() {
		return totalPedido;
	}

	public void setTotalPedido(Double totalPedido) {
		this.totalPedido = totalPedido;
	}

	public Integer getItems() {
		return items;
	}

	public void setItems(Integer items) {
		this.items = items;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

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

	public Long getProducto() {
		return producto;
	}

	public void setProducto(Long producto) {
		this.producto = producto;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	

	public MstPedido(Long id) {
		super();
		this.id = id;
	}
	
	
	public MstPedido() {}

	@Override
	public String toString() {
		return "MstPedido [id=" + id + ", ref=" + ref + ", cliente=" + cliente + ", producto=" + producto
				+ ", cantidad=" + cantidad + "]";
	}
	
	
	
}
