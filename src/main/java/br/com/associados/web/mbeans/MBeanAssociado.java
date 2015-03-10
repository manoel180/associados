package br.com.associados.web.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.TabChangeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.associados.controller.CadastroController;
import br.com.associados.model.Associado;
import br.com.associados.model.Cidade;
import br.com.associados.model.Endereco;
import br.com.associados.model.Estado;
import br.com.associados.model.FuncoesEclesiastica;

@Controller("mBeanAssociado")
@Scope("request")
public class MBeanAssociado extends mBeanGerneric{

        private Associado associado;
        private Estado estado;
        private List<FuncoesEclesiastica> funcaoEclesiasticas;
        private List<?> planos;
        private List<?> estados;
        private List<?> cidades;

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
                poupalateCombos();
                associado.setName("Manoel");
        }

        public void udpateTab(TabChangeEvent event){
                FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab: " + event.getTab().getTitle());
                event.getTab().processUpdates(FacesContext.getCurrentInstance());
                //FacesContext.getCurrentInstance().addMessage(null, msg); 
              //  RequestContext context = RequestContext.getCurrentInstance();  
             //   context.release();
        }
        private void poupalateCombos() {
                funcaoEclesiasticas = cadastroController
                                .listAllFuncaoEclesiastica();
                planos = cadastroController.listAllPlanos();
        }

        @Override
        public void salvar() {

                // Usuario user =
                // gson.fromJson(Connection.getConnection(Servicos.USUARIOS+"login="+login),
                // Usuario.class);
                // return user;
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
                System.out.println("n");
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

        public void setEstados(List<?> estados) {
                this.estados = estados;
        }

        public List<?> getCidades() {
                return cidades;
        }

        public void setCidades(List<?> cidades) {
                this.cidades = cidades;
        }

}
