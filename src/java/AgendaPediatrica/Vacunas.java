
package AgendaPediatrica;

import java.io.Serializable;
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
    /*@NamedQuery(name = "Vacunas.findAll", query = "SELECT v FROM Vacunas v")
    , @NamedQuery(name = "Vacunas.findById", query = "SELECT v FROM Vacunas v WHERE v.id = :id")
    , @NamedQuery(name = "Vacunas.findByDescripcionVacunas", query = "SELECT v FROM Vacunas v WHERE v.descripcionVacunas = :descripcionVacunas")
    , @NamedQuery(name = "Vacunas.findByEnfermedadVacunas", query = "SELECT v FROM Vacunas v WHERE v.enfermedadVacunas = :enfermedadVacunas")
    , @NamedQuery(name = "Vacunas.findByEdadAplicacion", query = "SELECT v FROM Vacunas v WHERE v.edadAplicacion = :edadAplicacion")
    , @NamedQuery(name = "Vacunas.findByUnidadTiempo", query = "SELECT v FROM Vacunas v WHERE v.unidadTiempo = :unidadTiempo")})*/
    @NamedQuery(name = "Vacunas.findByIdHijo", query = "SELECT v FROM Vacunas v WHERE v.idHijo = :idHijo")})
public class Vacunas implements Serializable {

    @Column(name = "aplicada")
    private Character aplicada;
    @Column(name = "fecha_aplicacion")
    @Temporal(TemporalType.DATE)
    private Date fechaAplicacion;
    //@Column(name = "id_hijo")
   // private Integer idHijo;
    
    @JoinColumn(name="id_hijo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Hijos idHijo;
    
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
  

    public Vacunas() {
    }

    public Vacunas(Integer id) {
        this.id = id;
    }

    public Vacunas(Integer id, String descripcionVacunas, String enfermedadVacunas, Date fechaAplicacion, String aplicada,Hijos id_hijo) {
        this.id = id;
        this.descripcionVacunas = descripcionVacunas;
        this.enfermedadVacunas = enfermedadVacunas;
        this.idHijo=id_hijo;
 
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

 
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: este método no funcionará en el caso de que los campos de identificación no estén establecidos
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

    
}
