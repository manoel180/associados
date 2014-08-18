package br.com.associados.web.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("mBeanPlano")
@Scope("request")
public class MBeanPlano {

	//private static final Logger logger = LoggerFactory.getLogger(TaskBackingBean.class);

	
	public String getMessage() {
		//logger.debug("Returning message from task home bean");
		return "Hello from Spring";
	}	

	

	public void saveTask() {
	}

}
