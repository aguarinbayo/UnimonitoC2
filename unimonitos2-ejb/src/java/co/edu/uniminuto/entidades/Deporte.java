/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Onescreen
 */
@Entity
@Table(name = "deporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deporte.findAll", query = "SELECT d FROM Deporte d")
    , @NamedQuery(name = "Deporte.findByIdDeporte", query = "SELECT d FROM Deporte d WHERE d.idDeporte = :idDeporte")
    , @NamedQuery(name = "Deporte.findByNombreDeporte", query = "SELECT d FROM Deporte d WHERE d.nombreDeporte = :nombreDeporte")})
public class Deporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDeporte")
    private Integer idDeporte;
    @Size(max = 45)
    @Column(name = "nombreDeporte")
    private String nombreDeporte;
    @OneToMany(mappedBy = "codDeporte")
    private Collection<Torneo> torneoCollection;

    public Deporte() {
    }

    public Deporte(Integer idDeporte) {
        this.idDeporte = idDeporte;
    }

    public Integer getIdDeporte() {
        return idDeporte;
    }

    public void setIdDeporte(Integer idDeporte) {
        this.idDeporte = idDeporte;
    }

    public String getNombreDeporte() {
        return nombreDeporte;
    }

    public void setNombreDeporte(String nombreDeporte) {
        this.nombreDeporte = nombreDeporte;
    }

    @XmlTransient
    public Collection<Torneo> getTorneoCollection() {
        return torneoCollection;
    }

    public void setTorneoCollection(Collection<Torneo> torneoCollection) {
        this.torneoCollection = torneoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDeporte != null ? idDeporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deporte)) {
            return false;
        }
        Deporte other = (Deporte) object;
        if ((this.idDeporte == null && other.idDeporte != null) || (this.idDeporte != null && !this.idDeporte.equals(other.idDeporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.entidades.Deporte[ idDeporte=" + idDeporte + " ]";
    }
    
}
