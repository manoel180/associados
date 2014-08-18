package br.com.associados.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.associados.dao.PlanoDao;
import br.com.associados.model.Plano;

/**
* Root resource (exposed at "myresource" path)
*/
@Path("/planos")
@Produces(MediaType.APPLICATION_JSON)
public class PlanoService {
	
	@Autowired
	private PlanoDao planoDao;

	/**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    public List<Plano> getPlano() {
        return planoDao.list();
    }
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("{id}")
    public Plano getPlano(@PathParam("id") Integer id) {
    	return planoDao.list().get(id);
    }
    
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("{id}/{status}")
    public Plano getPlano(@PathParam("id") Integer id, @PathParam("status") Boolean status) {
    	return planoDao.list().get(id);
    }
}
