package br.com.associados.web.mbeans;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;



@Controller("mBeanLogin")
@Scope("session")
public class MBeanLogin {

	
	public String getLogin() {
	    try {
		return SecurityContextHolder.getContext()
			.getAuthentication().getName();
		
	    } catch (Exception e) {
		// TODO: handle exception
	    }
	    return "";
	}

}
