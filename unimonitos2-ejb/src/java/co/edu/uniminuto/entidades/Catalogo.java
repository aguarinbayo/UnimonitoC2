/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Onescreen
 */
@Entity
@Table(name = "catalogo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Catalogo.findAll", query = "SELECT c FROM Catalogo c")
    , @NamedQuery(name = "Catalogo.findByIdCatalogo", query = "SELECT c FROM Catalogo c WHERE c.idCatalogo = :idCatalogo")
    , @NamedQuery(name = "Catalogo.findByFechaIn", query = "SELECT c FROM Catalogo c WHERE c.fechaIn = :fechaIn")
    , @NamedQuery(name = "Catalogo.findByFechaFn", query = "SELECT c FROM Catalogo c WHERE c.fechaFn = :fechaFn")
    , @NamedQuery(name = "Catalogo.findByEntrada", query = "SELECT c FROM Catalogo c WHERE c.entrada = :entrada")})
public class Catalogo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCatalogo")
    private Integer idCatalogo;
    @Column(name = "FechaIn")
    @Temporal(TemporalType.DATE)
    private Date fechaIn;
    @Column(name = "FechaFn")
    @Temporal(TemporalType.DATE)
    private Date fechaFn;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Entrada")
    private Float entrada;
    @OneToMany(mappedBy = "codCatalogo")
    private Collection<Boleteria> boleteriaCollection;
    @OneToMany(mappedBy = "codCatalogo")
    private Collection<Apuesta> apuestaCollection;
    @JoinColumn(name = "cod_Equipo2", referencedColumnName = "idEquipo")
    @ManyToOne
    private Equipo codEquipo2;
    @JoinColumn(name = "cod_Equipo1", referencedColumnName = "idEquipo")
    @ManyToOne
    private Equipo codEquipo1;

    public Catalogo() {
    }

    public Catalogo(Integer idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public Integer getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(Integer idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public Date getFechaIn() {
        return fechaIn;
    }

    public void setFechaIn(Date fechaIn) {
        this.fechaIn = fechaIn;
    }

    public Date getFechaFn() {
        return fechaFn;
    }

    public void setFechaFn(Date fechaFn) {
        this.fechaFn = fechaFn;
    }

    public Float getEntrada() {
        return entrada;
    }

    public void setEntrada(Float entrada) {
        this.entrada = entrada;
    }

    @XmlTransient
    public Collection<Boleteria> getBoleteriaCollection() {
        return boleteriaCollection;
    }

    public void setBoleteriaCollection(Collection<Boleteria> boleteriaCollection) {
        this.boleteriaCollection = boleteriaCollection;
    }

    @XmlTransient
    public Collection<Apuesta> getApuestaCollection() {
        return apuestaCollection;
    }

    public void setApuestaCollection(Collection<Apuesta> apuestaCollection) {
        this.apuestaCollection = apuestaCollection;
    }

    public Equipo getCodEquipo2() {
        return codEquipo2;
    }

    public void setCodEquipo2(Equipo codEquipo2) {
        this.codEquipo2 = codEquipo2;
    }

    public Equipo getCodEquipo1() {
        return codEquipo1;
    }

    public void setCodEquipo1(Equipo codEquipo1) {
        this.codEquipo1 = codEquipo1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCatalogo != null ? idCatalogo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catalogo)) {
            return false;
        }
        Catalogo other = (Catalogo) object;
        if ((this.idCatalogo == null && other.idCatalogo != null) || (this.idCatalogo != null && !this.idCatalogo.equals(other.idCatalogo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.entidades.Catalogo[ idCatalogo=" + idCatalogo + " ]";
    }
    
}
