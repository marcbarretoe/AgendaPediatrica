/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import AgendaPediatrica.Hijos;
import AgendaPediatrica.Vacunas;
import java.util.List;

/**
 *
 * @author marceloe
 */
public class HijosDTO {
    private Integer id;
    private String nombre;
    private String sexo;
    private List<Vacunas> vacunasCollection;
    
    public HijosDTO(){
    
    }

    public List<Vacunas> getVacunasCollection() {
        return vacunasCollection;
    }

    public void setVacunasCollection(List<Vacunas> vacunasCollection) {
        this.vacunasCollection = vacunasCollection;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
      
}
