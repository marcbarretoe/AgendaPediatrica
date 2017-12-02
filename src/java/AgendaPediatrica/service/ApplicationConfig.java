
package AgendaPediatrica.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author marceloe
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     
     * No modifique el método addRestResourceClasses ().
     * Se rellena automáticamente con
     * todos los recursos definidos en el proyecto.
     * Si es necesario, haga un comentario llamando a este método en getClasses ().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(AgendaPediatrica.service.HijosFacadeREST.class);
        resources.add(AgendaPediatrica.service.UsuariosFacadeREST.class);
        resources.add(AgendaPediatrica.service.VacunasFacadeREST.class);
    }
    
}
