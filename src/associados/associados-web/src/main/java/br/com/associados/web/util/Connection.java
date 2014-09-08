package br.com.associados.web.util;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;


public abstract class Connection {
	private static final String URL = "http://localhost:8088/associados-services/";
	private static Client c ;
	private static void openConnection() {
		ClientConfig clientConfig = new DefaultClientConfig();
		c = Client.create(clientConfig);
		
	}
	public static String getConnection(Servicos servico) {
		openConnection();
		WebResource wr = c.resource(URL+servico);
		String json = wr.accept(MediaType.APPLICATION_JSON).get(String.class);
		return json;
	}
	
	public static String getConnection(String servico) {
		openConnection();
		WebResource wr = c.resource(URL+servico);
		String json = wr.accept(MediaType.APPLICATION_JSON).get(String.class);
		return json;
	}
}
