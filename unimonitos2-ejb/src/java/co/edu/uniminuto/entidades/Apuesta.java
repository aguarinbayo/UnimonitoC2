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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Onescreen
 */
@Entity
@Table(name = "apuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Apuesta.findAll", query = "SELECT a FROM Apuesta a")
    , @NamedQuery(name = "Apuesta.findByIdApuesta", query = "SELECT a FROM Apuesta a WHERE a.idApuesta = :idApuesta")
    , @NamedQuery(name = "Apuesta.findByValorApuesta", query = "SELECT a FROM Apuesta a WHERE a.valorApuesta = :valorApuesta")
    , @NamedQuery(name = "Apuesta.findByMarcador", query = "SELECT a FROM Apuesta a WHERE a.marcador = :marcador")
    , @NamedQuery(name = "Apuesta.findByGanador", query = "SELECT a FROM Apuesta a WHERE a.ganador = :ganador")})
public class Apuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idApuesta")
    private Integer idApuesta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ValorApuesta")
    private Float valorApuesta;
    @Size(max = 45)
    @Column(name = "marcador")
    private String marcador;
    @Size(max = 45)
    @Column(name = "ganador")
    private String ganador;
    @JoinColumn(name = "cod_Catalogo", referencedColumnName = "idCatalogo")
    @ManyToOne
    private Catalogo codCatalogo;
    @JoinColumn(name = "cod_Usuario", referencedColumnName = "idUsuario")
    @ManyToOne
    private Usuario codUsuario;

    public Apuesta() {
    }

    public Apuesta(Integer idApuesta) {
        this.idApuesta = idApuesta;
    }

    public Integer getIdApuesta() {
        return idApuesta;
    }

    public void setIdApuesta(Integer idApuesta) {
        this.idApuesta = idApuesta;
    }

    public Float getValorApuesta() {
        return valorApuesta;
    }

    public void setValorApuesta(Float valorApuesta) {
        this.valorApuesta = valorApuesta;
    }

    public String getMarcador() {
        return marcador;
    }

    public void setMarcador(String marcador) {
        this.marcador = marcador;
    }

    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
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
        hash += (idApuesta != null ? idApuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apuesta)) {
            return false;
        }
        Apuesta other = (Apuesta) object;
        if ((this.idApuesta == null && other.idApuesta != null) || (this.idApuesta != null && !this.idApuesta.equals(other.idApuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.entidades.Apuesta[ idApuesta=" + idApuesta + " ]";
    }
    
}
