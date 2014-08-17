package br.com.associados.services;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

public class MyApplication  extends ResourceConfig {
	 public MyApplication () {
	        register(RequestContextFilter.class);
	        register(PlanoService.class);
	    }

}
