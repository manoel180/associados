package br.com.associados.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.associados.dao.PlanoDao;

@Component("mBeanPlano")
@Scope("request")
public class MBeanPlano {

	//private static final Logger logger = LoggerFactory.getLogger(TaskBackingBean.class);

	@Autowired
	private PlanoDao planoDao;

	
	public String getMessage() {
		//logger.debug("Returning message from task home bean");
		return "Hello from Spring";
	}	

	

	public void saveTask() {
	}

}
