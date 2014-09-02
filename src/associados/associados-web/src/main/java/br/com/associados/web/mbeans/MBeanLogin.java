package br.com.associados.web.mbeans;

import java.lang.reflect.Type;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.associados.web.dto.Usuario;
import br.com.associados.web.util.Connection;
import br.com.associados.web.util.Servicos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@ManagedBean(name="mBeanPlano")
@RequestScoped
public class MBeanLogin {

	public List<Usuario> getMessage() {
		Type listType = new TypeToken<List<Usuario>>() {}.getType();
		Gson gson = new Gson();
		List<Usuario> list = gson.fromJson(Connection.getConnection(Servicos.USUARIOS), listType);
		return list;
	}

	public void login() {
	}
	
	public void logout() {
		
	}

}
