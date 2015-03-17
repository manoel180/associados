package br.com.associados.web.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.associados.controller.CadastroController;
import br.com.associados.model.Perfil;
import br.com.associados.model.Usuario;
import br.com.associados.web.util.FacesUtil;

@Controller("mBeanUsuario")
@Scope("request")
public class MBeanUsuario extends mBeanGerneric {

    private Usuario usuario;

    private DualListModel<Perfil> perfis;
    private List<Perfil> perfisSource;
    private List<Perfil> perfisSelects;
    private String senha;
    

    @Autowired
    private CadastroController cadastroController;

    @PostConstruct
    public void init() {
	usuario = new Usuario();
	poupalateCombos();

    }

    @SuppressWarnings("unchecked")
    private void poupalateCombos() {
	perfisSource = (List<Perfil>) cadastroController.listAllPerfis();
	perfisSelects = new ArrayList<Perfil>();
	setPerfis(new DualListModel<Perfil>(perfisSource, perfisSelects));
    }

    @Override
    public void salvar() {

	try {
	    usuario.setPerfis(perfis.getTarget());
	    cadastroController.salvarUsuario(usuario);
	    FacesUtil.mensInfo("Usuário salvo com sucesso!");
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void listar() {

    }

    @Override
    public void excluir() {

    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public DualListModel<Perfil> getPerfis() {
	return perfis;
    }

    public void setPerfis(DualListModel<Perfil> perfis) {
	this.perfis = perfis;
    }

    public String getSenha() {
	return senha;
    }

    public void setSenha(String senha) {
	this.senha = senha;
    }



}
