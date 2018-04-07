package com.dvalpha.core.beans;

import com.dvalpha.core.entity.MstProducto;

public class MstCarritoBean {
private MstProducto producto;
private Long cantidad;
public MstProducto getProducto() {
	return producto;
}
public void setProducto(MstProducto producto) {
	this.producto = producto;
}
public Long getCantidad() {
	return cantidad;
}
public void setCantidad(Long cantidad) {
	this.cantidad = cantidad;
}



}
