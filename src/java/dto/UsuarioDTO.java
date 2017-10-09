/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
/**
 *
 * @author marceloe
 */
public class UsuarioDTO implements Serializable{
    private Integer id;
    private String nombre;
    private String correo;
    private Boolean valido;

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
    
    
}
