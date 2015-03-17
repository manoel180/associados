package br.com.associados.web.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FacesUtil {

	/**
	 * Apresenta uma mensagem de informacao.
	 * 
	 * @param title
	 *            o titulo da mensagem.
	 * @param message
	 *            a mensagem que sera apresentada.
	 */
	public static void mensInfo(String message) {
		mensagem(message, FacesMessage.SEVERITY_INFO);
	}

	/**
	 * Apresenta uma mensagem de erro.
	 * 
	 * @param title
	 *            o titulo da mensagem.
	 * @param message
	 *            a mensagem que sera apresentada.
	 */
	public static void mensErro(String message) {
		mensagem(message, FacesMessage.SEVERITY_ERROR);
	}

	/**
	 * Apresenta uma mensagem de atencao.
	 * 
	 * @param title
	 *            o titulo da mensagem.
	 * @param message
	 *            a mensagem que sera apresentada.
	 */
	public static void mensWarn(String message) {
		mensagem(message, FacesMessage.SEVERITY_WARN);
	}

	/**
	 * Apresenta a mensagem na UI.
	 * 
	 * @param title
	 *            o titulo da mensagem.
	 * @param message
	 *            a mensagem que sera apresentada.
	 * @param severity
	 *            o tipo de mensagem.
	 * @see FacesMessage
	 */
	public static void mensagem(String message, FacesMessage.Severity severity) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(severity, message, null));
	}

	public static String get(String param) {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get(param);
	}

	/**
	 * Obtem as mensagens do arquivo de propriedades.
	 * 
	 * @param key
	 *            a chave da mensagem no arquivo de propriedades.
	 * @return a mensagem referente a chave.
	 */
	public static final String getMessage(String key) {
		FacesContext context = FacesContext.getCurrentInstance();
		UIViewRoot viewRoot = context.getViewRoot();
		ResourceBundle bundle = ResourceBundle.getBundle("ui.Messages",
				viewRoot.getLocale());
		return bundle.getString(key);
	}

	/**
	 * Redireciona para a pagina informada pelo parametro.
	 * 
	 * @param originalViewId
	 *            a pagina que sera redirecionada.
	 */
	public static final void redirectPage(String originalViewId) {
		FacesContext context = FacesContext.getCurrentInstance();
		ViewHandler viewHandler = context.getApplication().getViewHandler();
		UIViewRoot viewRoot = viewHandler.createView(context, originalViewId);
		context.setViewRoot(viewRoot);
	}

	/**
	 * Método responsável por popular uma lista de selectItens a partir de uma
	 * lista de objetos.
	 * 
	 * @param lista
	 *            Lista de objetos que irá popular a lista de selectItem
	 * @return uma lista de selectItem
	 */
	public static List<SelectItem> toListSelectItem(List<? extends Object> lista) {
		List<SelectItem> items = new ArrayList<SelectItem>();
		for (Object o : lista) {
			items.add(new SelectItem(o, o.toString()));
		}
		return items;
	}

	/**
	 * Método responsável por retornar a sessão do contexto atual
	 * 
	 * @return um objeto que implementa a interface HttpSession
	 */
	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
	}

	public static ExternalContext getExternalContext() {
		return FacesContext.getCurrentInstance().getExternalContext();
	}

	public static Map getSessionMap() {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap();
	}

	public static ServletContext getServletContext() {
		return (ServletContext) FacesContext.getCurrentInstance()
				.getExternalContext().getContext();
	}

	public static HttpServletRequest getServletRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}

	public static HttpServletResponse getServletResponse() {
		return (HttpServletResponse) FacesContext.getCurrentInstance()
				.getExternalContext().getResponse();
	}
}
