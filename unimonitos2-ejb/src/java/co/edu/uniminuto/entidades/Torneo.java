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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Onescreen
 */
@Entity
@Table(name = "torneo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Torneo.findAll", query = "SELECT t FROM Torneo t")
    , @NamedQuery(name = "Torneo.findByIdTorneo", query = "SELECT t FROM Torneo t WHERE t.idTorneo = :idTorneo")
    , @NamedQuery(name = "Torneo.findByNombreTorneo", query = "SELECT t FROM Torneo t WHERE t.nombreTorneo = :nombreTorneo")
    , @NamedQuery(name = "Torneo.findByFechaTorneoIn", query = "SELECT t FROM Torneo t WHERE t.fechaTorneoIn = :fechaTorneoIn")
    , @NamedQuery(name = "Torneo.findByFechaTorneoOu", query = "SELECT t FROM Torneo t WHERE t.fechaTorneoOu = :fechaTorneoOu")})
public class Torneo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTorneo")
    private Integer idTorneo;
    @Size(max = 45)
    @Column(name = "nombreTorneo")
    private String nombreTorneo;
    @Column(name = "fechaTorneoIn")
    @Temporal(TemporalType.DATE)
    private Date fechaTorneoIn;
    @Column(name = "fechaTorneoOu")
    @Temporal(TemporalType.DATE)
    private Date fechaTorneoOu;
    @JoinColumn(name = "cod_Deporte", referencedColumnName = "idDeporte")
    @ManyToOne
    private Deporte codDeporte;
    @OneToMany(mappedBy = "codTorneo")
    private Collection<Equipo> equipoCollection;

    public Torneo() {
    }

    public Torneo(Integer idTorneo) {
        this.idTorneo = idTorneo;
    }

    public Integer getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(Integer idTorneo) {
        this.idTorneo = idTorneo;
    }

    public String getNombreTorneo() {
        return nombreTorneo;
    }

    public void setNombreTorneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }

    public Date getFechaTorneoIn() {
        return fechaTorneoIn;
    }

    public void setFechaTorneoIn(Date fechaTorneoIn) {
        this.fechaTorneoIn = fechaTorneoIn;
    }

    public Date getFechaTorneoOu() {
        return fechaTorneoOu;
    }

    public void setFechaTorneoOu(Date fechaTorneoOu) {
        this.fechaTorneoOu = fechaTorneoOu;
    }

    public Deporte getCodDeporte() {
        return codDeporte;
    }

    public void setCodDeporte(Deporte codDeporte) {
        this.codDeporte = codDeporte;
    }

    @XmlTransient
    public Collection<Equipo> getEquipoCollection() {
        return equipoCollection;
    }

    public void setEquipoCollection(Collection<Equipo> equipoCollection) {
        this.equipoCollection = equipoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTorneo != null ? idTorneo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Torneo)) {
            return false;
        }
        Torneo other = (Torneo) object;
        if ((this.idTorneo == null && other.idTorneo != null) || (this.idTorneo != null && !this.idTorneo.equals(other.idTorneo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.entidades.Torneo[ idTorneo=" + idTorneo + " ]";
    }
    
}
