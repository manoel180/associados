package br.com.associados.web.mbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.associados.web.dto.Usuario;
import br.com.associados.web.util.Connection;
import br.com.associados.web.util.Servicos;

import com.google.gson.Gson;

@ManagedBean(name="mBeanLogin")
@RequestScoped
public class MBeanLogin {

	private String login;
	public Usuario getUsuario() {
		//Type listType = new TypeToken<List<Usuario>>() {}.getType();
		Gson gson = new Gson();
		Usuario user = gson.fromJson(Connection.getConnection(Servicos.USUARIOS+"login="+login), Usuario.class);
		return user;
	}

	public String login() {
		if(getUsuario() != null) {
			return "home.jsf";
		}
		return "";
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
