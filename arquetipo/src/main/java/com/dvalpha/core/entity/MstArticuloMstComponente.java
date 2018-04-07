package com.dvalpha.core.entity;

import java.io.Serializable;

import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
	
@Entity
@Table(name = "mst_articulo_mst_componente")

@NamedQueries({
    @NamedQuery(name = "MstArticuloMstComponente.findAll", query = "SELECT m FROM MstArticuloMstComponente m"),
    @NamedQuery(name = "MstArticuloMstComponente.findById", query = "SELECT m FROM MstArticuloMstComponente m WHERE m.id = :id"),
    @NamedQuery(name = "MstArticuloMstComponente.findByCliente", query = "SELECT m FROM MstArticuloMstComponente m WHERE m.cliente = :cliente"),
    @NamedQuery(name = "MstArticuloMstComponente.findByCodigo", query = "SELECT m FROM MstArticuloMstComponente m WHERE m.codigo = :codigo"),
    @NamedQuery(name = "MstArticuloMstComponente.findByLinea", query = "SELECT m FROM MstArticuloMstComponente m WHERE m.linea = :linea"),
    @NamedQuery(name = "MstArticuloMstComponente.findByComponente", query = "SELECT m FROM MstArticuloMstComponente m WHERE m.componente = :componente"),
    @NamedQuery(name = "MstArticuloMstComponente.findByMaterial", query = "SELECT m FROM MstArticuloMstComponente m WHERE m.material = :material"),
    @NamedQuery(name = "MstArticuloMstComponente.findByIgual", query = "SELECT m FROM MstArticuloMstComponente m WHERE m.igual = :igual"),
    @NamedQuery(name = "MstArticuloMstComponente.findByCantidad", query = "SELECT m FROM MstArticuloMstComponente m WHERE m.cantidad = :cantidad"),
    @NamedQuery(name = "MstArticuloMstComponente.findByForma", query = "SELECT m FROM MstArticuloMstComponente m WHERE m.forma = :forma"),
    @NamedQuery(name = "MstArticuloMstComponente.findByPlantilla", query = "SELECT m FROM MstArticuloMstComponente m WHERE m.plantilla = :plantilla"),
    @NamedQuery(name = "MstArticuloMstComponente.findByDescripcion", query = "SELECT m FROM MstArticuloMstComponente m WHERE m.descripcion = :descripcion"),
    @NamedQuery(name = "MstArticuloMstComponente.findByLargo", query = "SELECT m FROM MstArticuloMstComponente m WHERE m.largo = :largo"),
    @NamedQuery(name = "MstArticuloMstComponente.findByAncho", query = "SELECT m FROM MstArticuloMstComponente m WHERE m.ancho = :ancho"),
    @NamedQuery(name = "MstArticuloMstComponente.findByAlto", query = "SELECT m FROM MstArticuloMstComponente m WHERE m.alto = :alto"),
    @NamedQuery(name = "MstArticuloMstComponente.findByDivision", query = "SELECT m FROM MstArticuloMstComponente m WHERE m.division = :division"),
    @NamedQuery(name = "MstArticuloMstComponente.findByObservac", query = "SELECT m FROM MstArticuloMstComponente m WHERE m.observac = :observac"),
    @NamedQuery(name = "MstArticuloMstComponente.findByPrecio", query = "SELECT m FROM MstArticuloMstComponente m WHERE m.precio = :precio"),
    @NamedQuery(name = "MstArticuloMstComponente.findByFingru", query = "SELECT m FROM MstArticuloMstComponente m WHERE m.fingru = :fingru"),
    @NamedQuery(name = "MstArticuloMstComponente.findByDupbasico", query = "SELECT m FROM MstArticuloMstComponente m WHERE m.dupbasico = :dupbasico"),
    @NamedQuery(name = "MstArticuloMstComponente.findByGrupo", query = "SELECT m FROM MstArticuloMstComponente m WHERE m.grupo = :grupo"),
    @NamedQuery(name = "MstArticuloMstComponente.findByDestino", query = "SELECT m FROM MstArticuloMstComponente m WHERE m.destino = :destino")})
public class MstArticuloMstComponente extends GenericEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;
   
    @Column(name = "cliente")
    private String cliente;

    @Column(name = "codigo")
    private int codigo;

    @Column(name = "linea")
    private int linea;
    
    /*
    @Column(name = "componente")
    private Integer componente;
    */
    
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "componente",referencedColumnName = "codigo") 
	private MstComponente componente;

    
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "material",referencedColumnName = "codigo") 
	private MstMateriales material;
    
	@Column(name = "igual")
    private String igual;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantidad")
    private Double cantidad;
    @Column(name = "forma")
    private String forma;
    @Column(name = "plantilla")
    private String plantilla;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "largo")
    private Integer largo;
    @Column(name = "ancho")
    private Integer ancho;
    @Column(name = "alto")
    private Integer alto;
    @Column(name = "division")
    private Integer division;
    @Column(name = "observac")
    private String observac;
    @Column(name = "precio")
    private Double precio;
    @Column(name = "fingru")
    private String fingru;
    @Column(name = "dupbasico")
    private String dupbasico;
    @Column(name = "grupo")
    private String grupo;
    @Column(name = "destino")
    private String destino;

    public MstArticuloMstComponente() {
    }

    public MstArticuloMstComponente(Long id) {
        this.id = id;
    }

    public MstArticuloMstComponente(Long id, String cliente, int codigo, int linea) {
        this.id = id;
        this.cliente = cliente;
        this.codigo = codigo;
        this.linea = linea;
    }

    
    
    public MstMateriales getMaterial() {
		return material;
	}

	public void setMaterial(MstMateriales material) {
		this.material = material;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

   /* public Integer getComponente() {
        return componente;
    }

    public void setComponente(Integer componente) {
        this.componente = componente;
    }
    */

    public MstComponente getComponente() {
		return componente;
	}

	public void setComponente(MstComponente componente) {
		this.componente = componente;
	}

	
    public String getIgual() {
        return igual;
    }

    public void setIgual(String igual) {
        this.igual = igual;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public String getPlantilla() {
        return plantilla;
    }

    public void setPlantilla(String plantilla) {
        this.plantilla = plantilla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getLargo() {
        return largo;
    }

    public void setLargo(Integer largo) {
        this.largo = largo;
    }

    public Integer getAncho() {
        return ancho;
    }

    public void setAncho(Integer ancho) {
        this.ancho = ancho;
    }

    public Integer getAlto() {
        return alto;
    }

    public void setAlto(Integer alto) {
        this.alto = alto;
    }

    public Integer getDivision() {
        return division;
    }

    public void setDivision(Integer division) {
        this.division = division;
    }

    public String getObservac() {
        return observac;
    }

    public void setObservac(String observac) {
        this.observac = observac;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getFingru() {
        return fingru;
    }

    public void setFingru(String fingru) {
        this.fingru = fingru;
    }

    public String getDupbasico() {
        return dupbasico;
    }

    public void setDupbasico(String dupbasico) {
        this.dupbasico = dupbasico;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstArticuloMstComponente)) {
            return false;
        }
        MstArticuloMstComponente other = (MstArticuloMstComponente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.MstArticuloMstComponente[ id=" + id + " ]";
    }
    
}

