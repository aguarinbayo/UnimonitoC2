/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.entidades;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Onescreen
 */
@Entity
@Table(name = "boleteria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boleteria.findAll", query = "SELECT b FROM Boleteria b")
    , @NamedQuery(name = "Boleteria.findByIdboleteria", query = "SELECT b FROM Boleteria b WHERE b.idboleteria = :idboleteria")})
public class Boleteria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idboleteria")
    private Integer idboleteria;
    @JoinColumn(name = "cod_catalogo", referencedColumnName = "idCatalogo")
    @ManyToOne
    private Catalogo codCatalogo;
    @JoinColumn(name = "cod_Usuario", referencedColumnName = "idUsuario")
    @ManyToOne
    private Usuario codUsuario;

    public Boleteria() {
    }

    public Boleteria(Integer idboleteria) {
        this.idboleteria = idboleteria;
    }

    public Integer getIdboleteria() {
        return idboleteria;
    }

    public void setIdboleteria(Integer idboleteria) {
        this.idboleteria = idboleteria;
    }

    public Catalogo getCodCatalogo() {
        return codCatalogo;
    }

    public void setCodCatalogo(Catalogo codCatalogo) {
        this.codCatalogo = codCatalogo;
    }

    public Usuario getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Usuario codUsuario) {
        this.codUsuario = codUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idboleteria != null ? idboleteria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Boleteria)) {
            return false;
        }
        Boleteria other = (Boleteria) object;
        if ((this.idboleteria == null && other.idboleteria != null) || (this.idboleteria != null && !this.idboleteria.equals(other.idboleteria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.entidades.Boleteria[ idboleteria=" + idboleteria + " ]";
    }
    
}
