package br.com.associados.services;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.associados.controller.CadastroController;
import br.com.associados.model.Plano;

/**
 * Root resource (exposed at "planos" path)
 */
@Path("/planos")
public class AssociadoService {

	@Autowired
	private CadastroController cadastroController;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newPlano(Plano plano) {


		return Response.status(200).entity(plano).build();

	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePlano(Plano plano) {

		return Response.status(200).entity(plano).build();

	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response deleteEmployee(@PathParam("id") Long id) throws ClassNotFoundException, SQLException {

	    return Response.status(200).build();
	}

	/**
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Plano> getPlano() {
		return cadastroController.listAllPlanos();
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Plano getPlano(@PathParam("id") Integer id) {
		return cadastroController.listAllPlanos().get(id);
	}

	/**
	 * 
	 * @param id
	 * @param status
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/{status}")
	public Plano getPlano(@PathParam("id") Integer id,
			@DefaultValue("true") @PathParam("status") Boolean status) {
		return cadastroController.listAllPlanos().get(id);
	}

}
