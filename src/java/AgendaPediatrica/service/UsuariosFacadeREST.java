/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AgendaPediatrica.service;

import AgendaPediatrica.Hijos;
import AgendaPediatrica.Usuarios;
import com.google.gson.Gson;
import dto.UsuarioDTO;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Evelyn
 */
//@Stateless
@Path("agendapediatrica.usuarios")
public class UsuariosFacadeREST extends AbstractFacade<Usuarios> {

    @PersistenceContext(unitName = "AgendaPediatricaPU")
    private EntityManager em;

    public UsuariosFacadeREST() {
        super(Usuarios.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Usuarios entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Usuarios entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Usuarios find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Usuarios> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Usuarios> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("ValidarUsuario")
    @Produces({MediaType.APPLICATION_JSON})
    public Response validarUsuario(String correo){
        Gson gson = new Gson();
        HashMap<String, String> mapa = gson.fromJson(correo,HashMap.class);
        System.out.println("email:"+mapa.get("correo"));

        return super.validarUsuario(mapa.get("correo"));
        
    }
    
     public Response validarUsuarioLocal(String correo) {
               
       UsuarioDTO usuarioDTO = new UsuarioDTO();
       try{
            Usuarios usuario= (Usuarios)getEntityManager().createNamedQuery("Usuarios.findByCorreoElectronico")
                    .setParameter("correoElectronico",correo).getSingleResult();
        
        
            usuarioDTO.setCorreo(usuario.getCorreoElectronico());
            usuarioDTO.setId(usuario.getId());
            usuarioDTO.setNombre(usuario.getNombre());
            usuarioDTO.setHijosCollection((List<Hijos>) usuario.getHijosCollection());
            usuarioDTO.setValido(Boolean.TRUE);
                
       } catch(Exception e){
           
           usuarioDTO.setId(0);
           usuarioDTO.setNombre("");
           usuarioDTO.setValido(Boolean.FALSE);
           e.printStackTrace();
           throw e;
       }
        return Response.ok(usuarioDTO).build();
    }
    @Override
    protected EntityManager getEntityManager() {
        return em=Persistence.createEntityManagerFactory("AgendaPediatricaPU").createEntityManager();
    }
    
      
       
    
}
