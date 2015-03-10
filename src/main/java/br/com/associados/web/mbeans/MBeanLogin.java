package br.com.associados.web.mbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.associados.model.Usuario;


@ManagedBean
@SessionScoped
public class MBeanLogin {

	private String login;
	public Usuario getUsuario() {
		//Type listType = new TypeToken<List<Usuario>>() {}.getType();
		//Gson gson = new Gson();
		//Usuario user = gson.fromJson(Connection.getConnection(Servicos.USUARIOS+"login="+login), Usuario.class);
		return null;
	}

	public String login() {
		return SecurityContextHolder.getContext()
        .getAuthentication().getName();
	}
	
	public void logout() {
		
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
