package com.dvalpha.core.entity;

import java.io.Serializable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "mst_client")
@NamedQueries({
    @NamedQuery(name = "MstClient.findAll", query = "SELECT m FROM MstClient m"),
    @NamedQuery(name = "MstClient.findById", query = "SELECT m FROM MstClient m WHERE m.id = :id"),
    @NamedQuery(name = "MstClient.findByCreacion", query = "SELECT m FROM MstClient m WHERE m.creacion = :creacion"),
    @NamedQuery(name = "MstClient.findByOrden", query = "SELECT m FROM MstClient m WHERE m.orden = :orden"),
    @NamedQuery(name = "MstClient.findByCodclient", query = "SELECT m FROM MstClient m WHERE m.codclient = :codclient"),
    @NamedQuery(name = "MstClient.findByNomclifiscal", query = "SELECT m FROM MstClient m WHERE m.nomclifiscal = :nomclifiscal"),
    @NamedQuery(name = "MstClient.findByNomclicom", query = "SELECT m FROM MstClient m WHERE m.nomclicom = :nomclicom"),
    @NamedQuery(name = "MstClient.findByCarrercli", query = "SELECT m FROM MstClient m WHERE m.carrercli = :carrercli"),
    @NamedQuery(name = "MstClient.findByCodposcli", query = "SELECT m FROM MstClient m WHERE m.codposcli = :codposcli"),
    @NamedQuery(name = "MstClient.findByPoblecli", query = "SELECT m FROM MstClient m WHERE m.poblecli = :poblecli"),
    @NamedQuery(name = "MstClient.findByPaiscli", query = "SELECT m FROM MstClient m WHERE m.paiscli = :paiscli"),
    @NamedQuery(name = "MstClient.findByProvincli", query = "SELECT m FROM MstClient m WHERE m.provincli = :provincli"),
    @NamedQuery(name = "MstClient.findByNifcli", query = "SELECT m FROM MstClient m WHERE m.nifcli = :nifcli"),
    @NamedQuery(name = "MstClient.findByTelefcli1", query = "SELECT m FROM MstClient m WHERE m.telefcli1 = :telefcli1"),
    @NamedQuery(name = "MstClient.findByTelefcli2", query = "SELECT m FROM MstClient m WHERE m.telefcli2 = :telefcli2"),
    @NamedQuery(name = "MstClient.findByMobilcli", query = "SELECT m FROM MstClient m WHERE m.mobilcli = :mobilcli"),
    @NamedQuery(name = "MstClient.findByFaxcli", query = "SELECT m FROM MstClient m WHERE m.faxcli = :faxcli"),
    @NamedQuery(name = "MstClient.findByEmailcli", query = "SELECT m FROM MstClient m WHERE m.emailcli = :emailcli"),
    @NamedQuery(name = "MstClient.findByWebcli", query = "SELECT m FROM MstClient m WHERE m.webcli = :webcli"),
    @NamedQuery(name = "MstClient.findByForpagcli", query = "SELECT m FROM MstClient m WHERE m.forpagcli = :forpagcli"),
    @NamedQuery(name = "MstClient.findByNombanccli", query = "SELECT m FROM MstClient m WHERE m.nombanccli = :nombanccli"),
    @NamedQuery(name = "MstClient.findByCtebanccli", query = "SELECT m FROM MstClient m WHERE m.ctebanccli = :ctebanccli"),
    @NamedQuery(name = "MstClient.findByDiapag1cli", query = "SELECT m FROM MstClient m WHERE m.diapag1cli = :diapag1cli"),
    @NamedQuery(name = "MstClient.findByDiapag2cli", query = "SELECT m FROM MstClient m WHERE m.diapag2cli = :diapag2cli"),
    @NamedQuery(name = "MstClient.findByPordteppcli", query = "SELECT m FROM MstClient m WHERE m.pordteppcli = :pordteppcli"),
    @NamedQuery(name = "MstClient.findByPorfinancli", query = "SELECT m FROM MstClient m WHERE m.porfinancli = :porfinancli"),
    @NamedQuery(name = "MstClient.findByPorivacli", query = "SELECT m FROM MstClient m WHERE m.porivacli = :porivacli"),
    @NamedQuery(name = "MstClient.findByContaadress", query = "SELECT m FROM MstClient m WHERE m.contaadress = :contaadress"),
    @NamedQuery(name = "MstClient.findByContacontact", query = "SELECT m FROM MstClient m WHERE m.contacontact = :contacontact"),
    @NamedQuery(name = "MstClient.findByAbm", query = "SELECT m FROM MstClient m WHERE m.abm = :abm")})

public class MstClient extends GenericEntity implements Serializable{


private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "codclient")
    private String codclient;
    @Column(name = "nomclifiscal")
    private String nomclifiscal;
    @Column(name = "nomclicom")
    private String nomclicom;
    @Column(name = "carrercli")
    private String carrercli;
    @Column(name = "codposcli")
    private String codposcli;
    @Column(name = "poblecli")
    private String poblecli;
    @Column(name = "paiscli")
    private Integer paiscli;
    @Column(name = "provincli")
    private Integer provincli;
    @Column(name = "nifcli")
    private String nifcli;
    @Column(name = "telefcli1")
    private String telefcli1;
    @Column(name = "telefcli2")
    private String telefcli2;
    @Column(name = "mobilcli")
    private String mobilcli;
    @Column(name = "faxcli")
    private String faxcli;
    @Column(name = "emailcli")
    private String emailcli;
    @Column(name = "webcli")
    private String webcli;
    @Column(name = "forpagcli")
    private Integer forpagcli;
    @Column(name = "nombanccli")
    private String nombanccli;
    @Column(name = "ctebanccli")
    private String ctebanccli;
    @Column(name = "diapag1cli")
    private Short diapag1cli;
    @Column(name = "diapag2cli")
    private Short diapag2cli;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pordteppcli")
    private Double pordteppcli;
    @Column(name = "porfinancli")
    private Double porfinancli;
    @Column(name = "porivacli")
    private Double porivacli;
    @Lob
    @Column(name = "observacionscli")
    private String observacionscli;
    @Column(name = "contaadress")
    private Integer contaadress;
    @Column(name = "contacontact")
    private Integer contacontact;
    @Column(name = "abm")
    private String abm;
    
	
	
	@LazyCollection(LazyCollectionOption.FALSE) //trae siempre las categorias
	@OneToMany(mappedBy="cliente",cascade=CascadeType.ALL) // hace referencia al campo libro de la tabla MstCategoriaLibro
	List<MstArticulo> articulos;
	
	
	
	
	public MstClient() {}
	public MstClient(Long id) {
		this.id=id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodclient() {
		return codclient;
	}
	public void setCodclient(String codclient) {
		this.codclient = codclient;
	}
	public String getNomclifiscal() {
		return nomclifiscal;
	}
	public void setNomclifiscal(String nomclifiscal) {
		this.nomclifiscal = nomclifiscal;
	}
	public String getNomclicom() {
		return nomclicom;
	}
	public void setNomclicom(String nomclicom) {
		this.nomclicom = nomclicom;
	}
	public String getCarrercli() {
		return carrercli;
	}
	public void setCarrercli(String carrercli) {
		this.carrercli = carrercli;
	}
	public String getCodposcli() {
		return codposcli;
	}
	public void setCodposcli(String codposcli) {
		this.codposcli = codposcli;
	}
	public String getPoblecli() {
		return poblecli;
	}
	public void setPoblecli(String poblecli) {
		this.poblecli = poblecli;
	}
	public Integer getPaiscli() {
		return paiscli;
	}
	public void setPaiscli(Integer paiscli) {
		this.paiscli = paiscli;
	}
	public Integer getProvincli() {
		return provincli;
	}
	public void setProvincli(Integer provincli) {
		this.provincli = provincli;
	}
	public String getNifcli() {
		return nifcli;
	}
	public void setNifcli(String nifcli) {
		this.nifcli = nifcli;
	}
	public String getTelefcli1() {
		return telefcli1;
	}
	public void setTelefcli1(String telefcli1) {
		this.telefcli1 = telefcli1;
	}
	public String getTelefcli2() {
		return telefcli2;
	}
	public void setTelefcli2(String telefcli2) {
		this.telefcli2 = telefcli2;
	}
	public String getMobilcli() {
		return mobilcli;
	}
	public void setMobilcli(String mobilcli) {
		this.mobilcli = mobilcli;
	}
	public String getFaxcli() {
		return faxcli;
	}
	public void setFaxcli(String faxcli) {
		this.faxcli = faxcli;
	}
	public String getEmailcli() {
		return emailcli;
	}
	public void setEmailcli(String emailcli) {
		this.emailcli = emailcli;
	}
	public String getWebcli() {
		return webcli;
	}
	public void setWebcli(String webcli) {
		this.webcli = webcli;
	}
	public Integer getForpagcli() {
		return forpagcli;
	}
	public void setForpagcli(Integer forpagcli) {
		this.forpagcli = forpagcli;
	}
	public String getNombanccli() {
		return nombanccli;
	}
	public void setNombanccli(String nombanccli) {
		this.nombanccli = nombanccli;
	}
	public String getCtebanccli() {
		return ctebanccli;
	}
	public void setCtebanccli(String ctebanccli) {
		this.ctebanccli = ctebanccli;
	}
	public Short getDiapag1cli() {
		return diapag1cli;
	}
	public void setDiapag1cli(Short diapag1cli) {
		this.diapag1cli = diapag1cli;
	}
	public Short getDiapag2cli() {
		return diapag2cli;
	}
	public void setDiapag2cli(Short diapag2cli) {
		this.diapag2cli = diapag2cli;
	}
	public Double getPordteppcli() {
		return pordteppcli;
	}
	public void setPordteppcli(Double pordteppcli) {
		this.pordteppcli = pordteppcli;
	}
	public Double getPorfinancli() {
		return porfinancli;
	}
	public void setPorfinancli(Double porfinancli) {
		this.porfinancli = porfinancli;
	}
	public Double getPorivacli() {
		return porivacli;
	}
	public void setPorivacli(Double porivacli) {
		this.porivacli = porivacli;
	}
	public String getObservacionscli() {
		return observacionscli;
	}
	public void setObservacionscli(String observacionscli) {
		this.observacionscli = observacionscli;
	}
	public Integer getContaadress() {
		return contaadress;
	}
	public void setContaadress(Integer contaadress) {
		this.contaadress = contaadress;
	}
	public Integer getContacontact() {
		return contacontact;
	}
	public void setContacontact(Integer contacontact) {
		this.contacontact = contacontact;
	}
	public String getAbm() {
		return abm;
	}
	public void setAbm(String abm) {
		this.abm = abm;
	}
	
	public List<MstArticulo> getArticulos() {
		return articulos;
	}
	public void setArticulos(List<MstArticulo> articulos) {
		this.articulos = articulos;
	}

	
	
	
}
