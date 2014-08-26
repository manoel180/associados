package br.com.associados.services;

import java.sql.SQLException;
import java.util.List;

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

import org.springframework.beans.factory.annotation.Autowired;

import br.com.associados.controller.CadastroController;
import br.com.associados.model.Usuario;

/**
 * Root resource (exposed at "planos" path)
 */
@Path("/usuarios")
public class UsuarioService {

	@Autowired
	private CadastroController cadastroController;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newUsuario(Usuario usuario) {

		return Response.status(200).entity(usuario).build();

	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUsuario(Usuario usuario) {

		return Response.status(200).entity(usuario).build();

	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response deleteUsuario(@PathParam("id") Long id) throws ClassNotFoundException, SQLException {

	    return Response.status(200).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Usuario getUsuarioById(@PathParam("id") Long id) {
		return cadastroController.getUsuarioById(id);
	}
		
	/**
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> getUsuarios() {
		return cadastroController.listAllUsuarios();
	}

}
