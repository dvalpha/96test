package com.dvalpha.core.beans;

public class MstUserBean {
	private int totalArchivos;
	private double espacioOcupado;
	public int getTotalArchivos() {
		return totalArchivos;
	}
	public void setTotalArchivos(int totalArchivos) {
		this.totalArchivos = totalArchivos;
	}
	public double getEspacioOcupado() {
		return espacioOcupado;
	}
	public void setEspacioOcupado(double espacioOcupado) {
		this.espacioOcupado = espacioOcupado;
	}
	@Override
	public String toString() {
		return "MstUserBean [totalArchivos=" + totalArchivos + ", espacioOcupado=" + espacioOcupado + "]";
	}
	
	
}
