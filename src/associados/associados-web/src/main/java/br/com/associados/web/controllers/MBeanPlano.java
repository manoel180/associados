package br.com.associados.web.controllers;

import java.util.Collection;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.associados.web.dto.Usuario;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

@Component("mBeanPlano")
@Scope("request")
public class MBeanPlano {

	// private static final Logger logger =
	// LoggerFactory.getLogger(TaskBackingBean.class);

	public List<Usuario> getMessage() {
		// logger.debug("Returning message from task home bean");
		Client c = Client.create();
		WebResource wr = c.resource("http://localhost:8080/associados-services/usuarios");
		String json = wr.get(String.class);
		Gson gson = new Gson();
		GenericType<Collection<Usuario>> customerType = new GenericType<Collection<Usuario>>() {
		};
		wr.get(customerType);
		return gson.fromJson(json, new TypeToken<List<Usuario>>(){}.getType());
//		return gson.fromJson(json, Usuario) new TypeToken<List<Usuario>>() {
//		}.getType());
	}

	public void saveTask() {
	}

}
