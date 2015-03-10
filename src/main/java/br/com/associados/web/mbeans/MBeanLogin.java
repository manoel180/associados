package br.com.associados.web.mbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.associados.model.Usuario;


@ManagedBean
@RequestScoped
public class MBeanLogin {

	private String login;
	public Usuario getUsuario() {
		//Type listType = new TypeToken<List<Usuario>>() {}.getType();
		//Gson gson = new Gson();
		//Usuario user = gson.fromJson(Connection.getConnection(Servicos.USUARIOS+"login="+login), Usuario.class);
		return null;
	}

	public String login() {
		if(true) {
			return "home.jsf";
		}
		return "home.jsf";
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
