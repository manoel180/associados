package br.com.associados.web.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.lindbergframework.spring.scope.AccessScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.associados.controller.CadastroController;
import br.com.associados.model.Associado;
import br.com.associados.model.Cidade;
import br.com.associados.model.Endereco;
import br.com.associados.model.Estado;
import br.com.associados.model.FuncoesEclesiastica;
import br.com.associados.web.util.FacesUtil;

@Controller("mBeanAssociado")
@AccessScoped
public class MBeanAssociado extends mBeanGerneric{

        private Associado associado;
        private Estado estado;
        private Cidade city;
        private List<FuncoesEclesiastica> funcaoEclesiasticas;
        private List<?> planos;
        private List<Estado> estados;
        private List<Cidade> cidades;

        @Autowired
        private CadastroController cadastroController;

        @PostConstruct
        public void init() {
                funcaoEclesiasticas = new ArrayList<FuncoesEclesiastica>();
                estados = new ArrayList<Estado>();
                associado = new Associado();
                associado.setEndereco(new Endereco());
                associado.getEndereco().setCidade(new Cidade());
                associado.getEndereco().getCidade().setEstado(new Estado());
                estado = new Estado();
                city = new Cidade();
                poupalateCombos();
        }
        
        public void loadCity() {
            cidades =  cadastroController.listAllCidadeByEstado(estado.getId());
        }

        private void poupalateCombos() {
            	estados = cadastroController.listAllEstados();
                funcaoEclesiasticas = cadastroController
                                .listAllFuncaoEclesiastica();
                planos = cadastroController.listAllPlanos();
        }

        @Override
        public void salvar() {
            	try {
		    cadastroController.salvarAssociado(associado);
		    FacesUtil.mensInfo("Associados salvo com sucesso!");
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

        public Associado getAssociado() {
                return associado;
        }

        public void setAssociado(Associado associado) {
                this.associado = associado;
        }

        /**
         * @return the funcaoEclesiasticas
         */
        public List<FuncoesEclesiastica> getFuncaoEclesiasticas() {
                return funcaoEclesiasticas;
                
        }

        /**
         * @param funcaoEclesiasticas
         *                the funcaoEclesiasticas to set
         */
        public void setFuncaoEclesiasticas(List<FuncoesEclesiastica> funcaoEclesiasticas) {
                this.funcaoEclesiasticas = funcaoEclesiasticas;
        }

        /**
         * @return the planos
         */
        public List<?> getPlanos() {
                return planos;
        }

        /**
         * @param planos
         *                the planos to set
         */
        public void setPlanos(List<?> planos) {
                this.planos = planos;
        }

        public Estado getEstado() {
                return estado;
        }

        public void setEstado(Estado estado) {
                this.estado = estado;
        }

        public List<?> getEstados() {
                return estados;
        }

        public void setEstados(List<Estado> estados) {
                this.estados = estados;
        }

        public List<Cidade> getCidades() {
                return cidades;
        }

        public void setCidades(List<Cidade> cidades) {
                this.cidades = cidades;
        }

	/**
	 * @return the city
	 */
	public Cidade getCity() {
	    return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(Cidade city) {
	    this.city = city;
	}

	
}
