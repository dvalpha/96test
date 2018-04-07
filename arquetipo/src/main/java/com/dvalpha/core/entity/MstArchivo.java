package com.dvalpha.core.entity;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "mst_archivo")
public class MstArchivo extends GenericEntity implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Lob
    @Column(name = "hash")
    private String hashCode;
	@Lob
    @Column(name = "file_path")
    private String filePath;
    @Lob
    @Column(name = "file_name_encode")
    private String fileNameEncode;
   
    
    @Column(name = "file_name")
    private String fileName;
    
    @Lob
    @Column(name = "url_path")
    private String urlPath;

    @Column(name = "extension")
    private String extension;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "etiqueta")
    private String etiqueta;
   
    

	
	@Column(name = "tamano")
    private Long tamano;
    
   
    @Column(name = "compartido")
    private Boolean compartido;
    
    @Column(name = "publico")
    private Boolean publico;
    
    @Column(name = "codificado")
    private Boolean codificado;
    
    
    @Column(name = "borrado")
    private boolean borrado;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_eliminacion")
    private Date fechaEliminacion;
    
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usuario",referencedColumnName = "id")
	private MstUsuario usuario;
    
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "directorio",referencedColumnName = "id") 
	private MstDirectorio directorio;
    
    public MstDirectorio getDirectorio() {
		return directorio;
	}


	public void setDirectorio(MstDirectorio directorio) {
		this.directorio = directorio;
	}


	@Override
	public String toString() {
		return "MstArchivo [id=" + id + ", filePath=" + filePath + ", fileNameEncode=" + fileNameEncode + ", fileName="
				+ fileName + ", urlPath=" + urlPath + ", extension=" + extension + ", tamano=" + tamano + ", compartido=" + compartido + ", publico=" + publico + ", codificado=" + codificado
				+ ", borrado=" + borrado + ", fechaEliminacion=" + fechaEliminacion + "]";
	}
    
   
	public String getEtiqueta() {
		return etiqueta;
	}
	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getHashCode() {
		return hashCode;
	}

	public void setHashCode(String hashCode) {
		this.hashCode = hashCode;
	}

	public Boolean getCompartido() {
		return compartido;
	}

	public void setCompartido(Boolean compartido) {
		this.compartido = compartido;
	}

	public Boolean getPublico() {
		return publico;
	}

	public void setPublico(Boolean publico) {
		this.publico = publico;
	}

	public MstUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(MstUsuario usuario) {
		this.usuario = usuario;
	}

	public MstArchivo() {}
    
    public MstArchivo(Long id) {
    	this.id=id;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileNameEncode() {
		return fileNameEncode;
	}

	public void setFileNameEncode(String fileNameEncode) {
		this.fileNameEncode = fileNameEncode;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getUrlPath() {
		return urlPath;
	}

	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public Long getTamano() {
		return tamano;
	}

	public void setTamano(Long tamano) {
		this.tamano = tamano;
	}

	

	

	public boolean isBorrado() {
		return borrado;
	}

	public void setBorrado(boolean borrado) {
		this.borrado = borrado;
	}

	public Date getFechaEliminacion() {
		return fechaEliminacion;
	}

	public void setFechaEliminacion(Date fechaEliminacion) {
		this.fechaEliminacion = fechaEliminacion;
	}

	public Boolean getCodificado() {
		return codificado;
	}

	public void setCodificado(Boolean codificado) {
		this.codificado = codificado;
	}
    
    
    
    
}
