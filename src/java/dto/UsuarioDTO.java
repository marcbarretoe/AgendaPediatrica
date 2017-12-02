/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import AgendaPediatrica.Hijos;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;


/**
 *
 * @author marceloe
 */
public class UsuarioDTO implements Serializable{
    private Integer id;
    private String nombre;
    private String correo;
    private Boolean valido;
    private List<Hijos> hijosCollection;

    //private String<hijoshijosCollection;
    
    public UsuarioDTO() {
        
    }
    
    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public Boolean getValido() {
        return valido;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setValido(Boolean valido) {
        this.valido = valido;
    }

    public List<Hijos> getHijosCollection() {
        return hijosCollection;
    }

    public void setHijosCollection(List<Hijos> hijosCollection) {
        this.hijosCollection = hijosCollection;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" + "id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", valido=" + valido + ", hijosCollection=" + hijosCollection + '}';
    }
}
