/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AgendaPediatrica.service;

import AgendaPediatrica.Hijos;
import AgendaPediatrica.Usuarios;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dto.HijosDTO;
import dto.UsuarioDTO;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


        
/**
 *
 * @author marceloe
 */

@Stateless
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

        return validarUsuarioLocal(mapa.get("correo"));
        
    }
    
//    @POST
//    @Consumes({MediaType.APPLICATION_JSON})
//    @Path("MostrarHijo")
//    @Produces({MediaType.APPLICATION_JSON})
//    public Response mostrarUsuarioHijo(String correoElectronico){
//        Gson gson = new Gson();
//        HashMap<String, String> mapa = gson.fromJson(correoElectronico,HashMap.class);
//        System.out.println("email:"+mapa.get("correoElectronico"));
//        //return mostrarHijoLocal(mapa.get("correoElectronico"));
//        
//        UsuarioDTO usuarioDTO = new UsuarioDTO();
//       try{
//            Usuarios usuario= (Usuarios)getEntityManager().createNamedQuery("Usuarios.findByCorreoElectronico")
//                    .setParameter("correoElectronico",correoElectronico).getSingleResult();
//            
//            //HashMap<String, String> mapa = gson.fromJson(usuario.getHijosCollection(),HashMap.class);
//            usuarioDTO.setCorreo(usuario.getCorreoElectronico());
//            usuarioDTO.setId(usuario.getId());
//            usuarioDTO.setNombre(usuario.getNombre());
//            usuarioDTO.setValido(Boolean.TRUE);
//            usuarioDTO.setHijosCollection(usuario.getHijosCollection());
//            
////            List<Hijos> hijos = usuario.getHijosCollection();
////            Map<Integer, Hijos> map = new HashMap<Integer, Hijos>();
////            for(int i=0; i<hijos.size(); i++) {
////                map.put(i, hijos.get(i));
////            }
//            //usuarioDTO.setHijosCollection(hijos.toArray(new Hijos[hijos.size()]));
//            
////            GenericEntity<List<Hijos>> list = new GenericEntity<List<Hijos>>(hijos) {};
////            return Response.ok(list).build();
////            
//           
////            Type listType = new TypeToken<List<Hijos>>() {}.getType();
////            List<Hijos> target = new LinkedList<Hijos>();
////            target.add(hijos.get(0));
////            target.add(hijos.get(1));
////            
////
////            Gson gson = new Gson();
////            String json = gson.toJson(target, listType);
////            List<String> target2 = gson.fromJson(json, listType);
//            
//            
//            //usuarioDTO.setValido(Boolean.TRUE);
//            
////            String representacionEsperada = "{\n" +
////		"  \"id\": 46,\n" +
////		"  \"nombre\": \"Miguel\",\n" +
////		"  \"empresa\": \"Autentia\"\n"+
////        "}";
//	//assertEquals(representacionEsperada, representacionBonita);
//         //   System.out.println("hijos?"+ma);
//      
//       } catch(Exception e){
//           usuarioDTO.setId(0);
//           usuarioDTO.setNombre("");
//           usuarioDTO.setValido(Boolean.FALSE);
//       }
//           
//        return Response.ok(usuarioDTO)
//                .build();        
//        
//    }

    @Override
    protected EntityManager getEntityManager() {
        return em=Persistence.createEntityManagerFactory("AgendaPediatricaPU").createEntityManager();
    }
    
    public Response validarUsuarioLocal(String correo){
               
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
           
       }
        return Response.ok(usuarioDTO).build();
    }
    
    public Response mostrarHijoLocal(String correo){
               
       UsuarioDTO usuarioDTO = new UsuarioDTO();
       //String json = new Gson().toJson(usuarioDTO.getHijosCollection());
       //Gson gson = new Gson();
       //String ma = gson.toJson(usuarioDTO.getHijosCollection());
       //List<Hijos> hijos;
       try{
            Usuarios usuario= (Usuarios)getEntityManager().createNamedQuery("Usuarios.findByCorreoElectronico")
                    .setParameter("correoElectronico",correo).getSingleResult();
            
            //HashMap<String, String> mapa = gson.fromJson(usuario.getHijosCollection(),HashMap.class);
           
            //usuarioDTO.setValido(Boolean.TRUE);
           // usuarioDTO.setHijosCollection(usuario.getHijosCollection());
            
//            List<Hijos> hijos = usuario.getHijosCollection();
//            Map<Integer, Hijos> map = new HashMap<Integer, Hijos>();
//            for(int i=0; i<hijos.size(); i++) {
//                map.put(i, hijos.get(i));
//            }
            //usuarioDTO.setHijosCollection(hijos.toArray(new Hijos[hijos.size()]));
            
//            GenericEntity<List<Hijos>> list = new GenericEntity<List<Hijos>>(hijos) {};
//            return Response.ok(list).build();
//            
           
//            Type listType = new TypeToken<List<Hijos>>() {}.getType();
//            List<Hijos> target = new LinkedList<Hijos>();
//            target.add(hijos.get(0));
//            target.add(hijos.get(1));
//            
//
//            Gson gson = new Gson();
//            String json = gson.toJson(target, listType);
//            List<String> target2 = gson.fromJson(json, listType);
            
            
            //usuarioDTO.setValido(Boolean.TRUE);
            
//            String representacionEsperada = "{\n" +
//		"  \"id\": 46,\n" +
//		"  \"nombre\": \"Miguel\",\n" +
//		"  \"empresa\": \"Autentia\"\n"+
//        "}";
	//assertEquals(representacionEsperada, representacionBonita);
         //   System.out.println("hijos?"+ma);
      
       } catch(Exception e){
           usuarioDTO.setId(0);
           usuarioDTO.setNombre("");
           usuarioDTO.setValido(Boolean.FALSE);
       }
           
        return Response.ok(usuarioDTO)
                .build();
        //return Response.ok(json).build();
    }
    
}
