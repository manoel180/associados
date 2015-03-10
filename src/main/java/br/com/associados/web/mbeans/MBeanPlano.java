package br.com.associados.web.mbeans;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class MBeanPlano extends mBeanGerneric{

	// private static final Logger logger =
	// LoggerFactory.getLogger(TaskBackingBean.class);
	
	@PostConstruct
	private void init() {
		
	}

	@Override
	public void salvar() {
	}

	@Override
	public void listar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir() {
		// TODO Auto-generated method stub
		
	}

}
