package br.com.associados.web.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.associados.controller.CadastroController;
import br.com.associados.model.Funcionalidade;
import br.com.associados.model.Perfil;

@Controller("mBeanPerfil")
@Scope("request")
public class MBeanPerfil extends mBeanGerneric {

    private Perfil perfil;

    private DualListModel<Funcionalidade> funcionalidades;
    private List<Funcionalidade> funcionalidadesSource;
    private List<Funcionalidade> funcionalidadesSelects;

    @Autowired
    private CadastroController cadastroController;

    @PostConstruct
    public void init() {
	perfil = new Perfil();
	poupalateCombos();

    }

    @SuppressWarnings("unchecked")
    private void poupalateCombos() {
	funcionalidadesSource = cadastroController.listAllFuncionalidades();
	funcionalidadesSelects = new ArrayList<Funcionalidade>();
	setFuncionalidades(new DualListModel<Funcionalidade>(funcionalidadesSource, funcionalidadesSelects));
    }

    @Override
    public void salvar() {

	try {
	    perfil.setPerfilFuncionalidades(funcionalidades.getTarget());
	    cadastroController.salvarPerfil(perfil);
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

    public DualListModel<Funcionalidade> getFuncionalidades() {
	return funcionalidades;
    }

    public void setFuncionalidades(DualListModel<Funcionalidade> funcionalidades) {
	this.funcionalidades = funcionalidades;
    }

    public Perfil getPerfil() {
	return perfil;
    }

    public void setPerfil(Perfil perfil) {
	this.perfil = perfil;
    }



}
