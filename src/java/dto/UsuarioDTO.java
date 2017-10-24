/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import AgendaPediatrica.Hijos;
import java.io.Serializable;
import java.util.Collection;
/**
 *
 * @author marceloe
 */
public class UsuarioDTO implements Serializable{
    private Integer id;
    private String nombre;
    private String correo;
    private Boolean valido;
    private Collection<Hijos>hijosCollection;
    //private String<hijoshijosCollection;
    
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

    public Collection<Hijos> getHijosCollection() {
        return hijosCollection;
    }

    public void setHijosCollection(Collection<Hijos> hijosCollection) {
        this.hijosCollection = hijosCollection;
    }
    
    
}
