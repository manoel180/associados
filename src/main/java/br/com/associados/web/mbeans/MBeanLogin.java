package br.com.associados.web.mbeans;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import br.com.associados.model.Usuario;



@Controller("mBeanLogin")
@Scope("session")
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
