/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AgendaPediatrica;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "hijos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hijos.findAll", query = "SELECT h FROM Hijos h")
    , @NamedQuery(name = "Hijos.findById", query = "SELECT h FROM Hijos h WHERE h.id = :id")
    , @NamedQuery(name = "Hijos.findByDocumentoIdentidad", query = "SELECT h FROM Hijos h WHERE h.documentoIdentidad = :documentoIdentidad")
    , @NamedQuery(name = "Hijos.findByNombres", query = "SELECT h FROM Hijos h WHERE h.nombres = :nombres")
    , @NamedQuery(name = "Hijos.findByApellidos", query = "SELECT h FROM Hijos h WHERE h.apellidos = :apellidos")
    , @NamedQuery(name = "Hijos.findByFechaNacimiento", query = "SELECT h FROM Hijos h WHERE h.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Hijos.findByLugarNacimiento", query = "SELECT h FROM Hijos h WHERE h.lugarNacimiento = :lugarNacimiento")
    , @NamedQuery(name = "Hijos.findBySexo", query = "SELECT h FROM Hijos h WHERE h.sexo = :sexo")
    , @NamedQuery(name = "Hijos.findByNacionalidad", query = "SELECT h FROM Hijos h WHERE h.nacionalidad = :nacionalidad")
    , @NamedQuery(name = "Hijos.findByDireccion", query = "SELECT h FROM Hijos h WHERE h.direccion = :direccion")
    , @NamedQuery(name = "Hijos.findByDepartamento", query = "SELECT h FROM Hijos h WHERE h.departamento = :departamento")
    , @NamedQuery(name = "Hijos.findByMunicipio", query = "SELECT h FROM Hijos h WHERE h.municipio = :municipio")
    , @NamedQuery(name = "Hijos.findByBarrio", query = "SELECT h FROM Hijos h WHERE h.barrio = :barrio")
    , @NamedQuery(name = "Hijos.findByReferenciaDomicilio", query = "SELECT h FROM Hijos h WHERE h.referenciaDomicilio = :referenciaDomicilio")
    , @NamedQuery(name = "Hijos.findByTelContacto", query = "SELECT h FROM Hijos h WHERE h.telContacto = :telContacto")
    , @NamedQuery(name = "Hijos.findBySeguroMedico", query = "SELECT h FROM Hijos h WHERE h.seguroMedico = :seguroMedico")
    , @NamedQuery(name = "Hijos.findByAlergiaContraindicacion", query = "SELECT h FROM Hijos h WHERE h.alergiaContraindicacion = :alergiaContraindicacion")
    , @NamedQuery(name = "Hijos.findByIdUsuario", query = "SELECT h FROM Hijos h WHERE h.idUsuario = :idUsuario")})
//, @NamedQuery(name = "Hijos.findByIdUsuario", query = "SELECT h FROM Hijos h WHERE h.idUsuario = :idUsuario")
public class Hijos implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_vacunas")
    private int idVacunas;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "documento_identidad")
    private BigInteger documentoIdentidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "lugar_nacimiento")
    private String lugarNacimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sexo")
    private Character sexo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "departamento")
    private String departamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "municipio")
    private String municipio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "barrio")
    private String barrio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "referencia_domicilio")
    private String referenciaDomicilio;
    @Size(max = 2147483647)
    @Column(name = "tel_contacto")
    private String telContacto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seguro_medico")
    private Character seguroMedico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "alergia_contraindicacion")
    private String alergiaContraindicacion;
    //@JoinColumn(name = "id_padres", referencedColumnName = "id")
    //@ManyToOne(optional = false)
    //private Padres idPadres;
    
    @JoinColumn(name="id_usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;
    
    
    //private Usuarios usuario;
    //@ManyToOne
    //private Vacunas vacunas;

    
    public Hijos() {
    }

    public Hijos(Integer id) {
        this.id = id;
    }

    public Hijos(Integer id, BigInteger documentoIdentidad, String nombres, String apellidos, Date fechaNacimiento, String lugarNacimiento, Character sexo, String nacionalidad, String direccion, String departamento, String municipio, String barrio, String referenciaDomicilio, Character seguroMedico, String alergiaContraindicacion, Usuarios usuario) {
        this.id = id;
        this.documentoIdentidad = documentoIdentidad;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.lugarNacimiento = lugarNacimiento;
        this.sexo = sexo;
        this.nacionalidad = nacionalidad;
        this.direccion = direccion;
        this.departamento = departamento;
        this.municipio = municipio;
        this.barrio = barrio;
        this.referenciaDomicilio = referenciaDomicilio;
        this.seguroMedico = seguroMedico;
        this.alergiaContraindicacion = alergiaContraindicacion;
       // this.vacunas = idVacunas;
        //this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(BigInteger documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getReferenciaDomicilio() {
        return referenciaDomicilio;
    }

    public void setReferenciaDomicilio(String referenciaDomicilio) {
        this.referenciaDomicilio = referenciaDomicilio;
    }

    public String getTelContacto() {
        return telContacto;
    }

    public void setTelContacto(String telContacto) {
        this.telContacto = telContacto;
    }

    public Character getSeguroMedico() {
        return seguroMedico;
    }

    public void setSeguroMedico(Character seguroMedico) {
        this.seguroMedico = seguroMedico;
    }

    public String getAlergiaContraindicacion() {
        return alergiaContraindicacion;
    }

    public void setAlergiaContraindicacion(String alergiaContraindicacion) {
        this.alergiaContraindicacion = alergiaContraindicacion;
    }
/*
    public Padres getIdPadres() {
        return idPadres;
    }

    public void setIdPadres(Padres idPadres) {
        this.idPadres = idPadres;
    }
*/

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
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
        if (!(object instanceof Hijos)) {
            return false;
        }
        Hijos other = (Hijos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AgendaPediatrica.Hijos[ id=" + id + " ]";
    }

    public int getIdVacunas() {
        return idVacunas;
    }

    public void setIdVacunas(int idVacunas) {
        this.idVacunas = idVacunas;
    }
    
}
