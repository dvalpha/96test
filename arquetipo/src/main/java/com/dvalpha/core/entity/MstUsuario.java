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
@Table(name = "mst_usuario")
public class MstUsuario extends GenericEntity implements Serializable{


private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "usuario" )
	private String user;
	
	@Column(name = "session_timeout")
    private String sessiontimeout;
	
	@Column(name = "passw")
	private String password;
	
	@Column(name = "acepto_legal")
    private boolean acepto_condiciones_legales;
	 
	
	
	@Column(name = "avatar")
	private String avatar; 
	
	@Column(name = "nombre")
    private String nombre;
	
	@Column(name = "apellidos")
    private String apellidos;  
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "telefono")
	private String telefono;
	
	
	/**
	 * Dependencias
	 * 
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mstcentro_id",referencedColumnName = "id")
	private MstCentro mstcentro;

	@JoinColumn(name = "mstrol_id",referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.EAGER)
	private MstRol mstrol;
	
	@JoinColumn(name = "defdepartamentos",referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.EAGER)
	private DefDepartamentos defdepartamentos;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private MstStorage mststorage;
	
	@LazyCollection(LazyCollectionOption.FALSE) 
	@OneToMany(mappedBy="usuario",cascade=CascadeType.ALL) 
	public List<MstArchivo> archivos;
	
	//Campos para operaciones
	public double espacioOcupado;
	
	
	public double getEspacioOcupado() {
		return espacioOcupado;
	}
	public void setEspacioOcupado(double espacioOcupado) {
		this.espacioOcupado = espacioOcupado;
	}
	public DefDepartamentos getDefdepartamentos() {
		return defdepartamentos;
	}
	public void setDefdepartamentos(DefDepartamentos defdepartamentos) {
		this.defdepartamentos = defdepartamentos;
	}
	public List<MstArchivo> getArchivos() {
		return archivos;
	}
	public void setArchivos(List<MstArchivo> archivos) {
		this.archivos = archivos;
	}
	public MstStorage getMststorage() {
		return mststorage;
	}
	public void setMststorage(MstStorage mststorage) {
		this.mststorage = mststorage;
	}
	public MstUsuario() {}
	public MstUsuario(Long id) {
		this.id=id;
	}
	public MstRol getMstrol() {
		return mstrol;
	}

	public void setMstrol(MstRol mstrol) {
		this.mstrol = mstrol;
	}
	
	public MstCentro getMstcentro() {
		return mstcentro;
	}

	public void setMstcentro(MstCentro mstcentro) {
		this.mstcentro = mstcentro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSessiontimeout() {
		return sessiontimeout;
	}

	public void setSessiontimeout(String sessiontimeout) {
		this.sessiontimeout = sessiontimeout;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAcepto_condiciones_legales() {
		return acepto_condiciones_legales;
	}

	public void setAcepto_condiciones_legales(boolean acepto_condiciones_legales) {
		this.acepto_condiciones_legales = acepto_condiciones_legales;
	}

	

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "MstUsuario [id=" + id + ", user=" + user + ", sessiontimeout=" + sessiontimeout + ", password="
				+ password + ", acepto_condiciones_legales=" + acepto_condiciones_legales + ", avatar=" + avatar + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
				+ ", telefono=" + telefono + "]";
	}
	
	
	
}
