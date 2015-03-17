package br.com.associados.web.mbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import br.com.associados.controller.CadastroController;
import br.com.associados.model.Usuario;

@Controller("mBeanLogin")
@Scope("session")
public class MBeanLogin {

    @Autowired
    CadastroController cadastroController;

    private Usuario usuario;

    public String getLogin() {
	try {
	    if (!SecurityContextHolder.getContext().getAuthentication()
		    .getName().equals("admin")) {
		usuario = cadastroController
			.getUsuarioByLogin(SecurityContextHolder.getContext()
				.getAuthentication().getName());
		return usuario.getNome();
	    }
	    return "Administrador";

	} catch (Exception e) {
	    // TODO: handle exception
	}
	return "";
    }

}
