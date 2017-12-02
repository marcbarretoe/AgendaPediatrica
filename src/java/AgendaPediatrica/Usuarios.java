
package AgendaPediatrica;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;




/**
 *
 * @author marceloe
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findByNombre", query = "SELECT u FROM Usuarios u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuarios.findByCorreoElectronico", query = "SELECT u FROM Usuarios u WHERE u.correoElectronico = :correoElectronico")
    , @NamedQuery(name = "Usuarios.findById", query = "SELECT u FROM Usuarios u WHERE u.id = :id")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "nombre")
    private String nombre;
    @Id
    @Basic(optional = false)
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    
   
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario", fetch = FetchType.EAGER)
    //@JoinTable(name="id")
    private Collection<Hijos> hijosCollection;


    public Usuarios() {
    }

    public Usuarios(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Usuarios(String correoElectronico, int id) {
        this.correoElectronico = correoElectronico;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (correoElectronico != null ? correoElectronico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        //TODO:este método no funcionará en el caso de que los campos de identificación no estén establecidos
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.correoElectronico == null && other.correoElectronico != null) || (this.correoElectronico != null && !this.correoElectronico.equals(other.correoElectronico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AgendaPediatrica.Usuarios[ correoElectronico=" + correoElectronico + " ]";
    }
    @XmlTransient
    public Collection<Hijos> getHijosCollection() {
        return hijosCollection;
    }

    public void setHijosCollection(Collection<Hijos> hijosCollection) {
        this.hijosCollection = hijosCollection;
    }

    

   
    
    
    
}
