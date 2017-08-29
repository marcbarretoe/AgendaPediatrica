/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AgendaPediatrica;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author marceloe
 */
@Entity
@Table(name = "padres")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Padres.findAll", query = "SELECT p FROM Padres p")
    , @NamedQuery(name = "Padres.findById", query = "SELECT p FROM Padres p WHERE p.id = :id")
    , @NamedQuery(name = "Padres.findByNombre", query = "SELECT p FROM Padres p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Padres.findByApellidos", query = "SELECT p FROM Padres p WHERE p.apellidos = :apellidos")
    , @NamedQuery(name = "Padres.findByCedula", query = "SELECT p FROM Padres p WHERE p.cedula = :cedula")
    , @NamedQuery(name = "Padres.findByFechaNacimiento", query = "SELECT p FROM Padres p WHERE p.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Padres.findByCedulaConyuge", query = "SELECT p FROM Padres p WHERE p.cedulaConyuge = :cedulaConyuge")})
public class Padres implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPadres")
    private Collection<Hijos> hijosCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cedula")
    private String cedula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 2147483647)
    @Column(name = "cedula_conyuge")
    private String cedulaConyuge;

    public Padres() {
    }

    public Padres(Integer id) {
        this.id = id;
    }

    public Padres(Integer id, String nombre, String apellidos, String cedula, Date fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCedulaConyuge() {
        return cedulaConyuge;
    }

    public void setCedulaConyuge(String cedulaConyuge) {
        this.cedulaConyuge = cedulaConyuge;
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
        if (!(object instanceof Padres)) {
            return false;
        }
        Padres other = (Padres) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AgendaPediatrica.Padres[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<Hijos> getHijosCollection() {
        return hijosCollection;
    }

    public void setHijosCollection(Collection<Hijos> hijosCollection) {
        this.hijosCollection = hijosCollection;
    }
    
}
