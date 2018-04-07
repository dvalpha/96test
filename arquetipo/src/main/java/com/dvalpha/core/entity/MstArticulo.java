package com.dvalpha.core.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.JoinColumn;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@Table(name = "mst_articulo")

@NamedQueries({
    @NamedQuery(name = "MstArticulo.findAll", query = "SELECT m FROM MstArticulo m"),
    @NamedQuery(name = "MstArticulo.findById", query = "SELECT m FROM MstArticulo m WHERE m.id = :id"),
    @NamedQuery(name = "MstArticulo.findByCreacion", query = "SELECT m FROM MstArticulo m WHERE m.creacion = :creacion"),
    @NamedQuery(name = "MstArticulo.findByOrden", query = "SELECT m FROM MstArticulo m WHERE m.orden = :orden"),
    @NamedQuery(name = "MstArticulo.findByCodigoCliente", query = "SELECT m FROM MstArticulo m WHERE m.codigoCliente = :codigoCliente"),
    @NamedQuery(name = "MstArticulo.findByCodigo", query = "SELECT m FROM MstArticulo m WHERE m.codigo = :codigo"),
    @NamedQuery(name = "MstArticulo.findByArticulo", query = "SELECT m FROM MstArticulo m WHERE m.articulo = :articulo"),
    @NamedQuery(name = "MstArticulo.findByModelo", query = "SELECT m FROM MstArticulo m WHERE m.modelo = :modelo"),
    @NamedQuery(name = "MstArticulo.findByArtignifugo", query = "SELECT m FROM MstArticulo m WHERE m.artignifugo = :artignifugo"),
    @NamedQuery(name = "MstArticulo.findByOrdenmod", query = "SELECT m FROM MstArticulo m WHERE m.ordenmod = :ordenmod"),
    @NamedQuery(name = "MstArticulo.findByArtnormesp", query = "SELECT m FROM MstArticulo m WHERE m.artnormesp = :artnormesp"),
    @NamedQuery(name = "MstArticulo.findByArtbasico", query = "SELECT m FROM MstArticulo m WHERE m.artbasico = :artbasico"),
    @NamedQuery(name = "MstArticulo.findByArtlargo", query = "SELECT m FROM MstArticulo m WHERE m.artlargo = :artlargo"),
    @NamedQuery(name = "MstArticulo.findByArtprvdef", query = "SELECT m FROM MstArticulo m WHERE m.artprvdef = :artprvdef"),
    @NamedQuery(name = "MstArticulo.findByConlin", query = "SELECT m FROM MstArticulo m WHERE m.conlin = :conlin"),
    @NamedQuery(name = "MstArticulo.findByCantdto1", query = "SELECT m FROM MstArticulo m WHERE m.cantdto1 = :cantdto1"),
    @NamedQuery(name = "MstArticulo.findByPorcdto1", query = "SELECT m FROM MstArticulo m WHERE m.porcdto1 = :porcdto1"),
    @NamedQuery(name = "MstArticulo.findByCantdto2", query = "SELECT m FROM MstArticulo m WHERE m.cantdto2 = :cantdto2"),
    @NamedQuery(name = "MstArticulo.findByPorcdto2", query = "SELECT m FROM MstArticulo m WHERE m.porcdto2 = :porcdto2"),
    @NamedQuery(name = "MstArticulo.findByPantdto3", query = "SELECT m FROM MstArticulo m WHERE m.pantdto3 = :pantdto3"),
    @NamedQuery(name = "MstArticulo.findByPorcdto3", query = "SELECT m FROM MstArticulo m WHERE m.porcdto3 = :porcdto3"),
    @NamedQuery(name = "MstArticulo.findByCantdto4", query = "SELECT m FROM MstArticulo m WHERE m.cantdto4 = :cantdto4"),
    @NamedQuery(name = "MstArticulo.findByPorcdto4", query = "SELECT m FROM MstArticulo m WHERE m.porcdto4 = :porcdto4"),
    @NamedQuery(name = "MstArticulo.findByCantdto5", query = "SELECT m FROM MstArticulo m WHERE m.cantdto5 = :cantdto5"),
    @NamedQuery(name = "MstArticulo.findByPorcdto5", query = "SELECT m FROM MstArticulo m WHERE m.porcdto5 = :porcdto5"),
    @NamedQuery(name = "MstArticulo.findByPantdto6", query = "SELECT m FROM MstArticulo m WHERE m.pantdto6 = :pantdto6"),
    @NamedQuery(name = "MstArticulo.findByPorcdto6", query = "SELECT m FROM MstArticulo m WHERE m.porcdto6 = :porcdto6"),
    @NamedQuery(name = "MstArticulo.findByCantdto7", query = "SELECT m FROM MstArticulo m WHERE m.cantdto7 = :cantdto7"),
    @NamedQuery(name = "MstArticulo.findByPorcdto7", query = "SELECT m FROM MstArticulo m WHERE m.porcdto7 = :porcdto7"),
    @NamedQuery(name = "MstArticulo.findByCantdto8", query = "SELECT m FROM MstArticulo m WHERE m.cantdto8 = :cantdto8"),
    @NamedQuery(name = "MstArticulo.findByPorcdto8", query = "SELECT m FROM MstArticulo m WHERE m.porcdto8 = :porcdto8"),
    @NamedQuery(name = "MstArticulo.findByCantdto9", query = "SELECT m FROM MstArticulo m WHERE m.cantdto9 = :cantdto9"),
    @NamedQuery(name = "MstArticulo.findByPorcdto9", query = "SELECT m FROM MstArticulo m WHERE m.porcdto9 = :porcdto9"),
    @NamedQuery(name = "MstArticulo.findByCantdto10", query = "SELECT m FROM MstArticulo m WHERE m.cantdto10 = :cantdto10"),
    @NamedQuery(name = "MstArticulo.findByPorcdto10", query = "SELECT m FROM MstArticulo m WHERE m.porcdto10 = :porcdto10"),
    @NamedQuery(name = "MstArticulo.findByCantdto11", query = "SELECT m FROM MstArticulo m WHERE m.cantdto11 = :cantdto11"),
    @NamedQuery(name = "MstArticulo.findByPorcdto11", query = "SELECT m FROM MstArticulo m WHERE m.porcdto11 = :porcdto11"),
    @NamedQuery(name = "MstArticulo.findByContmovstck", query = "SELECT m FROM MstArticulo m WHERE m.contmovstck = :contmovstck")})
public class MstArticulo extends GenericEntity implements Serializable{


private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "codigo_cliente")
    private String codigoCliente;
    @Basic(optional = false)
    @Column(name = "codigo")
    private int codigo;
    @Column(name = "articulo")
    private String articulo;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "artignifugo")
    private String artignifugo;
    @Column(name = "ordenmod")
    private Integer ordenmod;
    @Column(name = "artnormesp")
    private String artnormesp;
    @Column(name = "artbasico")
    private String artbasico;
    @Column(name = "artlargo")
    private Integer artlargo;
    @Column(name = "artprvdef")
    private String artprvdef;
    @Column(name = "conlin")
    private Integer conlin;
    @Column(name = "cantdto1")
    private Integer cantdto1;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcdto1")
    private Double porcdto1;
    @Column(name = "cantdto2")
    private Integer cantdto2;
    @Column(name = "porcdto2")
    private Double porcdto2;
    @Column(name = "pantdto3")
    private Integer pantdto3;
    @Column(name = "porcdto3")
    private Double porcdto3;
    @Column(name = "cantdto4")
    private Integer cantdto4;
    @Column(name = "porcdto4")
    private Double porcdto4;
    @Column(name = "cantdto5")
    private Integer cantdto5;
    @Column(name = "porcdto5")
    private Double porcdto5;
    @Column(name = "pantdto6")
    private Integer pantdto6;
    @Column(name = "porcdto6")
    private Double porcdto6;
    @Column(name = "cantdto7")
    private Integer cantdto7;
    @Column(name = "porcdto7")
    private Double porcdto7;
    @Column(name = "cantdto8")
    private Integer cantdto8;
    @Column(name = "porcdto8")
    private Double porcdto8;
    @Column(name = "cantdto9")
    private Integer cantdto9;
    @Column(name = "porcdto9")
    private Double porcdto9;
    @Column(name = "cantdto10")
    private Integer cantdto10;
    @Column(name = "porcdto10")
    private Double porcdto10;
    @Column(name = "cantdto11")
    private Integer cantdto11;
    @Column(name = "porcdto11")
    private Double porcdto11;
    @Column(name = "contmovstck")
    private Integer contmovstck;
   
	
	/*@ManyToMany(cascade = { CascadeType.REMOVE },fetch = FetchType.EAGER)
    @JoinTable(
        name = "mst_articulo_mst_componente", 
        joinColumns = { @JoinColumn(name = "componente_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "articulo_id") }
    )
   
	
	//@ManyToMany(targetEntity=MstComponente.class,fetch = FetchType.EAGER)
   // private List<MstComponente> componentes = new ArrayList<MstComponente>();
	
	@Column(name = "articulo" )
	private String articulo;
	
	@Column(name = "codigo" )
	private String codigo;
	
	@Column(name = "codigo_cliente" )
	private String codigoCliente;
	
	@Column(name = "modelo_name" )
	private String modeloNombre;
	*/
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cliente",referencedColumnName = "id") 
	private MstClient cliente;

	
	public MstArticulo() {}
	public MstArticulo(Long id) {
		this.id=id;
	}
	
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getArtignifugo() {
        return artignifugo;
    }

    public void setArtignifugo(String artignifugo) {
        this.artignifugo = artignifugo;
    }

    public Integer getOrdenmod() {
        return ordenmod;
    }

    public void setOrdenmod(Integer ordenmod) {
        this.ordenmod = ordenmod;
    }

    public String getArtnormesp() {
        return artnormesp;
    }

    public void setArtnormesp(String artnormesp) {
        this.artnormesp = artnormesp;
    }

    public String getArtbasico() {
        return artbasico;
    }

    public void setArtbasico(String artbasico) {
        this.artbasico = artbasico;
    }

    public Integer getArtlargo() {
        return artlargo;
    }

    public void setArtlargo(Integer artlargo) {
        this.artlargo = artlargo;
    }

    public String getArtprvdef() {
        return artprvdef;
    }

    public void setArtprvdef(String artprvdef) {
        this.artprvdef = artprvdef;
    }

    public Integer getConlin() {
        return conlin;
    }

    public void setConlin(Integer conlin) {
        this.conlin = conlin;
    }

    public Integer getCantdto1() {
        return cantdto1;
    }

    public void setCantdto1(Integer cantdto1) {
        this.cantdto1 = cantdto1;
    }

    public Double getPorcdto1() {
        return porcdto1;
    }

    public void setPorcdto1(Double porcdto1) {
        this.porcdto1 = porcdto1;
    }

    public Integer getCantdto2() {
        return cantdto2;
    }

    public void setCantdto2(Integer cantdto2) {
        this.cantdto2 = cantdto2;
    }

    public Double getPorcdto2() {
        return porcdto2;
    }

    public void setPorcdto2(Double porcdto2) {
        this.porcdto2 = porcdto2;
    }

    public Integer getPantdto3() {
        return pantdto3;
    }

    public void setPantdto3(Integer pantdto3) {
        this.pantdto3 = pantdto3;
    }

    public Double getPorcdto3() {
        return porcdto3;
    }

    public void setPorcdto3(Double porcdto3) {
        this.porcdto3 = porcdto3;
    }

    public Integer getCantdto4() {
        return cantdto4;
    }

    public void setCantdto4(Integer cantdto4) {
        this.cantdto4 = cantdto4;
    }

    public Double getPorcdto4() {
        return porcdto4;
    }

    public void setPorcdto4(Double porcdto4) {
        this.porcdto4 = porcdto4;
    }

    public Integer getCantdto5() {
        return cantdto5;
    }

    public void setCantdto5(Integer cantdto5) {
        this.cantdto5 = cantdto5;
    }

    public Double getPorcdto5() {
        return porcdto5;
    }

    public void setPorcdto5(Double porcdto5) {
        this.porcdto5 = porcdto5;
    }

    public Integer getPantdto6() {
        return pantdto6;
    }

    public void setPantdto6(Integer pantdto6) {
        this.pantdto6 = pantdto6;
    }

    public Double getPorcdto6() {
        return porcdto6;
    }

    public void setPorcdto6(Double porcdto6) {
        this.porcdto6 = porcdto6;
    }

    public Integer getCantdto7() {
        return cantdto7;
    }

    public void setCantdto7(Integer cantdto7) {
        this.cantdto7 = cantdto7;
    }

    public Double getPorcdto7() {
        return porcdto7;
    }

    public void setPorcdto7(Double porcdto7) {
        this.porcdto7 = porcdto7;
    }

    public Integer getCantdto8() {
        return cantdto8;
    }

    public void setCantdto8(Integer cantdto8) {
        this.cantdto8 = cantdto8;
    }

    public Double getPorcdto8() {
        return porcdto8;
    }

    public void setPorcdto8(Double porcdto8) {
        this.porcdto8 = porcdto8;
    }

    public Integer getCantdto9() {
        return cantdto9;
    }

    public void setCantdto9(Integer cantdto9) {
        this.cantdto9 = cantdto9;
    }

    public Double getPorcdto9() {
        return porcdto9;
    }

    public void setPorcdto9(Double porcdto9) {
        this.porcdto9 = porcdto9;
    }

    public Integer getCantdto10() {
        return cantdto10;
    }

    public void setCantdto10(Integer cantdto10) {
        this.cantdto10 = cantdto10;
    }

    public Double getPorcdto10() {
        return porcdto10;
    }

    public void setPorcdto10(Double porcdto10) {
        this.porcdto10 = porcdto10;
    }

    public Integer getCantdto11() {
        return cantdto11;
    }

    public void setCantdto11(Integer cantdto11) {
        this.cantdto11 = cantdto11;
    }

    public Double getPorcdto11() {
        return porcdto11;
    }

    public void setPorcdto11(Double porcdto11) {
        this.porcdto11 = porcdto11;
    }

    public Integer getContmovstck() {
        return contmovstck;
    }

    public void setContmovstck(Integer contmovstck) {
        this.contmovstck = contmovstck;
    }

    

    public MstClient getCliente() {
        return cliente;
    }

    public void setCliente(MstClient cliente) {
        this.cliente = cliente;
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
        if (!(object instanceof MstArticulo)) {
            return false;
        }
        MstArticulo other = (MstArticulo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

	
	
	
	
}
