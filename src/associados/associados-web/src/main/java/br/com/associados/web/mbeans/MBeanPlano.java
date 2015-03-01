package br.com.associados.web.mbeans;

import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.associados.web.dto.Usuario;
import br.com.associados.web.util.Connection;
import br.com.associados.web.util.Servicos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@ManagedBean
@RequestScoped
public class MBeanPlano extends mBeanGerneric{

	// private static final Logger logger =
	// LoggerFactory.getLogger(TaskBackingBean.class);

	@PostConstruct
	private void init() {
		
	}
	public List<Usuario> getMessage() {
		Type listType = new TypeToken<List<Usuario>>() {}.getType();
		Gson gson = new Gson();
		List<Usuario> list = gson.fromJson(Connection.getConnection(Servicos.PLANOS), listType);
		return list;
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
