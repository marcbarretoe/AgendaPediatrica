/*
 * To change this license header, choose License Headers in Project Properties.
    * To change this template file, choose Tools | Templates
    * and open the template in the editor.
 */
package AgendaPediatrica.service;

import AgendaPediatrica.Hijos;
import AgendaPediatrica.Usuarios;
import AgendaPediatrica.Vacunas;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import dto.HijosDTO;
import dto.UsuarioDTO;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

/**
 *
 * @author marceloe
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    
    public Response validarUsuario(String correo){
               
       UsuarioDTO usuarioDTO = new UsuarioDTO();
       try{
            Usuarios usuario= (Usuarios)getEntityManager().createNamedQuery("Usuarios.findByCorreoElectronico")
                    .setParameter("correoElectronico",correo).getSingleResult();
        
        
            usuarioDTO.setCorreo(usuario.getCorreoElectronico());
            usuarioDTO.setId(usuario.getId());
            usuarioDTO.setNombre(usuario.getNombre());
            usuarioDTO.setValido(Boolean.TRUE);
                
       } catch(Exception e){
           usuarioDTO.setId(0);
           usuarioDTO.setNombre("");
           usuarioDTO.setValido(Boolean.FALSE);
           
       }
        return Response.ok(usuarioDTO).build();
    }
    
    
       public Response mostrarHijo(String idUsuario){
               
       UsuarioDTO usuarioDTO = new UsuarioDTO();
       try{
            Usuarios usuario= (Usuarios)getEntityManager().createNamedQuery("Usuarios.findById")
                    .setParameter("id",Long.valueOf(idUsuario)).getSingleResult();
        
            usuarioDTO.setHijosCollection((List<Hijos>) usuario.getHijosCollection());
         
          
       } catch(Exception e){
           usuarioDTO.setId(0);
           usuarioDTO.setNombre("");
           usuarioDTO.setValido(Boolean.FALSE);
       }
        return Response.ok(usuarioDTO).build();
    }
    
    public Response obtenerVacunasHijo(String idHijo) {
               
       HijosDTO hijoDTO = new HijosDTO();
       try{
            Hijos hijo = (Hijos)getEntityManager().createNamedQuery("Hijos.findById")
                    .setParameter("id",Long.valueOf(idHijo)).getSingleResult();
        
            hijoDTO.setVacunasCollection((List)hijo.getVacunasCollection());
                
       } catch(Exception e){
           
           hijoDTO.setId(0);
           
           e.printStackTrace();
           throw e;
       }
        return Response.ok(hijoDTO).build();
    }
}



