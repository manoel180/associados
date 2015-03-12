package br.com.associados.web.mbeans;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;



@Controller("mBeanLogin")
@Scope("session")
//@ManagedBean
//@SessionScoped
public class MBeanLogin {

	private String login;
	
	public String login() {
	    try {
		return SecurityContextHolder.getContext()
			.getAuthentication().getName();
		
	    } catch (Exception e) {
		// TODO: handle exception
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
