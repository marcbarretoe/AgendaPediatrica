/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AgendaPediatrica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marceloe
 */
@Entity
@Table(name = "vacunas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vacunas.findAll", query = "SELECT v FROM Vacunas v")
    , @NamedQuery(name = "Vacunas.findById", query = "SELECT v FROM Vacunas v WHERE v.id = :id")
    , @NamedQuery(name = "Vacunas.findByDescripcionVacunas", query = "SELECT v FROM Vacunas v WHERE v.descripcionVacunas = :descripcionVacunas")
    , @NamedQuery(name = "Vacunas.findByEnfermedadVacunas", query = "SELECT v FROM Vacunas v WHERE v.enfermedadVacunas = :enfermedadVacunas")
    , @NamedQuery(name = "Vacunas.findByEdadAplicacion", query = "SELECT v FROM Vacunas v WHERE v.edadAplicacion = :edadAplicacion")
    , @NamedQuery(name = "Vacunas.findByUnidadTiempo", query = "SELECT v FROM Vacunas v WHERE v.unidadTiempo = :unidadTiempo")})
public class Vacunas implements Serializable {

    @Column(name = "aplicada")
    private Character aplicada;
    @Column(name = "fecha_aplicacion")
    @Temporal(TemporalType.DATE)
    private Date fechaAplicacion;
    @Column(name = "id_hijo")
    private Integer idHijo;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion_vacunas")
    private String descripcionVacunas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "enfermedad_vacunas")
    private String enfermedadVacunas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "edad_aplicacion")
    private String edadAplicacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "unidad_tiempo")
    private String unidadTiempo;

    public Vacunas() {
    }

    public Vacunas(Integer id) {
        this.id = id;
    }

    public Vacunas(Integer id, String descripcionVacunas, String enfermedadVacunas, String edadAplicacion, String unidadTiempo) {
        this.id = id;
        this.descripcionVacunas = descripcionVacunas;
        this.enfermedadVacunas = enfermedadVacunas;
        this.edadAplicacion = edadAplicacion;
        this.unidadTiempo = unidadTiempo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcionVacunas() {
        return descripcionVacunas;
    }

    public void setDescripcionVacunas(String descripcionVacunas) {
        this.descripcionVacunas = descripcionVacunas;
    }

    public String getEnfermedadVacunas() {
        return enfermedadVacunas;
    }

    public void setEnfermedadVacunas(String enfermedadVacunas) {
        this.enfermedadVacunas = enfermedadVacunas;
    }

    public String getEdadAplicacion() {
        return edadAplicacion;
    }

    public void setEdadAplicacion(String edadAplicacion) {
        this.edadAplicacion = edadAplicacion;
    }

    public String getUnidadTiempo() {
        return unidadTiempo;
    }

    public void setUnidadTiempo(String unidadTiempo) {
        this.unidadTiempo = unidadTiempo;
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
        if (!(object instanceof Vacunas)) {
            return false;
        }
        Vacunas other = (Vacunas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AgendaPediatrica.Vacunas[ id=" + id + " ]";
    }

    public Character getAplicada() {
        return aplicada;
    }

    public void setAplicada(Character aplicada) {
        this.aplicada = aplicada;
    }

    public Date getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(Date fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public Integer getIdHijo() {
        return idHijo;
    }

    public void setIdHijo(Integer idHijo) {
        this.idHijo = idHijo;
    }
    
}
