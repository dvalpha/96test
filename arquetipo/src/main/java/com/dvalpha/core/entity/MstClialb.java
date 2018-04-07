package com.dvalpha.core.entity;
import java.io.Serializable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "mst_clialb")
@NamedQueries({
    @NamedQuery(name = "MstClialb.findAll", query = "SELECT m FROM MstClialb m"),
    @NamedQuery(name = "MstClialb.findById", query = "SELECT m FROM MstClialb m WHERE m.id = :id"),
    @NamedQuery(name = "MstClialb.findBySeralb", query = "SELECT m FROM MstClialb m WHERE m.seralb = :seralb"),
    @NamedQuery(name = "MstClialb.findByNumalb", query = "SELECT m FROM MstClialb m WHERE m.numalb = :numalb"),
    @NamedQuery(name = "MstClialb.findByFechaalb", query = "SELECT m FROM MstClialb m WHERE m.fechaalb = :fechaalb"),
    @NamedQuery(name = "MstClialb.findByCodclient", query = "SELECT m FROM MstClialb m WHERE m.codclient = :codclient"),
    @NamedQuery(name = "MstClialb.findByNomcli", query = "SELECT m FROM MstClialb m WHERE m.nomcli = :nomcli"),
    @NamedQuery(name = "MstClialb.findByDircli", query = "SELECT m FROM MstClialb m WHERE m.dircli = :dircli"),
    @NamedQuery(name = "MstClialb.findByPobcli", query = "SELECT m FROM MstClialb m WHERE m.pobcli = :pobcli"),
    @NamedQuery(name = "MstClialb.findByCodpos", query = "SELECT m FROM MstClialb m WHERE m.codpos = :codpos"),
    @NamedQuery(name = "MstClialb.findByCoddir", query = "SELECT m FROM MstClialb m WHERE m.coddir = :coddir"),
    @NamedQuery(name = "MstClialb.findByNomclidir", query = "SELECT m FROM MstClialb m WHERE m.nomclidir = :nomclidir"),
    @NamedQuery(name = "MstClialb.findByDirclidir", query = "SELECT m FROM MstClialb m WHERE m.dirclidir = :dirclidir"),
    @NamedQuery(name = "MstClialb.findByPobclidir", query = "SELECT m FROM MstClialb m WHERE m.pobclidir = :pobclidir"),
    @NamedQuery(name = "MstClialb.findByCodposdir", query = "SELECT m FROM MstClialb m WHERE m.codposdir = :codposdir"),
    @NamedQuery(name = "MstClialb.findByClicmda", query = "SELECT m FROM MstClialb m WHERE m.clicmda = :clicmda"),
    @NamedQuery(name = "MstClialb.findByContalinies", query = "SELECT m FROM MstClialb m WHERE m.contalinies = :contalinies"),
    @NamedQuery(name = "MstClialb.findBySemana1", query = "SELECT m FROM MstClialb m WHERE m.semana1 = :semana1"),
    @NamedQuery(name = "MstClialb.findBySemana2", query = "SELECT m FROM MstClialb m WHERE m.semana2 = :semana2"),
    @NamedQuery(name = "MstClialb.findBySemana3", query = "SELECT m FROM MstClialb m WHERE m.semana3 = :semana3"),
    @NamedQuery(name = "MstClialb.findBySerfra", query = "SELECT m FROM MstClialb m WHERE m.serfra = :serfra"),
    @NamedQuery(name = "MstClialb.findByNumfra", query = "SELECT m FROM MstClialb m WHERE m.numfra = :numfra")})
public class MstClialb extends GenericEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "seralb")
    private String seralb;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numalb")
    private int numalb;
    @Column(name = "fechaalb")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaalb;
    @Size(max = 6)
    @Column(name = "codclient")
    private String codclient;
    @Size(max = 50)
    @Column(name = "nomcli")
    private String nomcli;
    @Size(max = 50)
    @Column(name = "dircli")
    private String dircli;
    @Size(max = 40)
    @Column(name = "pobcli")
    private String pobcli;
    @Size(max = 10)
    @Column(name = "codpos")
    private String codpos;
    @Size(max = 2)
    @Column(name = "coddir")
    private String coddir;
    @Size(max = 40)
    @Column(name = "nomclidir")
    private String nomclidir;
    @Size(max = 50)
    @Column(name = "dirclidir")
    private String dirclidir;
    @Size(max = 40)
    @Column(name = "pobclidir")
    private String pobclidir;
    @Size(max = 10)
    @Column(name = "codposdir")
    private String codposdir;
    @Size(max = 6)
    @Column(name = "clicmda")
    private String clicmda;
    @Column(name = "contalinies")
    private Integer contalinies;
    @Column(name = "semana1")
    private Integer semana1;
    @Column(name = "semana2")
    private Integer semana2;
    @Column(name = "semana3")
    private Integer semana3;
    @Size(max = 1)
    @Column(name = "serfra")
    private String serfra;
    @Column(name = "numfra")
    private Integer numfra;

    public MstClialb() {
    }
    public MstClialb(Long id) {
    	this.id=id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeralb() {
        return seralb;
    }

    public void setSeralb(String seralb) {
        this.seralb = seralb;
    }

    public int getNumalb() {
        return numalb;
    }

    public void setNumalb(int numalb) {
        this.numalb = numalb;
    }
    public Date getFechaalb() {
        return fechaalb;
    }

    public void setFechaalb(Date fechaalb) {
        this.fechaalb = fechaalb;
    }

    public String getCodclient() {
        return codclient;
    }

    public void setCodclient(String codclient) {
        this.codclient = codclient;
    }

    public String getNomcli() {
        return nomcli;
    }

    public void setNomcli(String nomcli) {
        this.nomcli = nomcli;
    }

    public String getDircli() {
        return dircli;
    }

    public void setDircli(String dircli) {
        this.dircli = dircli;
    }

    public String getPobcli() {
        return pobcli;
    }

    public void setPobcli(String pobcli) {
        this.pobcli = pobcli;
    }

    public String getCodpos() {
        return codpos;
    }

    public void setCodpos(String codpos) {
        this.codpos = codpos;
    }

    public String getCoddir() {
        return coddir;
    }

    public void setCoddir(String coddir) {
        this.coddir = coddir;
    }

    public String getNomclidir() {
        return nomclidir;
    }

    public void setNomclidir(String nomclidir) {
        this.nomclidir = nomclidir;
    }

    public String getDirclidir() {
        return dirclidir;
    }

    public void setDirclidir(String dirclidir) {
        this.dirclidir = dirclidir;
    }

    public String getPobclidir() {
        return pobclidir;
    }

    public void setPobclidir(String pobclidir) {
        this.pobclidir = pobclidir;
    }

    public String getCodposdir() {
        return codposdir;
    }

    public void setCodposdir(String codposdir) {
        this.codposdir = codposdir;
    }

    public String getClicmda() {
        return clicmda;
    }

    public void setClicmda(String clicmda) {
        this.clicmda = clicmda;
    }

    public Integer getContalinies() {
        return contalinies;
    }

    public void setContalinies(Integer contalinies) {
        this.contalinies = contalinies;
    }

    public Integer getSemana1() {
        return semana1;
    }

    public void setSemana1(Integer semana1) {
        this.semana1 = semana1;
    }

    public Integer getSemana2() {
        return semana2;
    }

    public void setSemana2(Integer semana2) {
        this.semana2 = semana2;
    }

    public Integer getSemana3() {
        return semana3;
    }

    public void setSemana3(Integer semana3) {
        this.semana3 = semana3;
    }

    public String getSerfra() {
        return serfra;
    }

    public void setSerfra(String serfra) {
        this.serfra = serfra;
    }

    public Integer getNumfra() {
        return numfra;
    }

    public void setNumfra(Integer numfra) {
        this.numfra = numfra;
    }
	@Override
	public String toString() {
		return "MstClialb [id=" + id + ", seralb=" + seralb + ", numalb=" + numalb + ", fechaalb=" + fechaalb
				+ ", codclient=" + codclient + ", nomcli=" + nomcli + ", dircli=" + dircli + ", pobcli=" + pobcli
				+ ", codpos=" + codpos + ", coddir=" + coddir + ", nomclidir=" + nomclidir + ", dirclidir=" + dirclidir
				+ ", pobclidir=" + pobclidir + ", codposdir=" + codposdir + ", clicmda=" + clicmda + ", contalinies="
				+ contalinies + ", semana1=" + semana1 + ", semana2=" + semana2 + ", semana3=" + semana3 + ", serfra="
				+ serfra + ", numfra=" + numfra + "]";
	}

    

}
