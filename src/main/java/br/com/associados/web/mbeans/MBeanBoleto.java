package br.com.associados.web.mbeans;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.associados.controller.CadastroController;
import br.com.associados.model.Boleto;
import br.com.associados.web.util.FacesUtil;

@Controller("mBeanBoleto")
@Scope("request")
public class MBeanBoleto extends mBeanGerneric{

        private Boleto boleto;

        @Autowired
        private CadastroController cadastroController;

        @PostConstruct
        public void init() {
            poupalateCombos();
        }

        private void poupalateCombos() {
            
        }

        @Override
        public void salvar() {
            	try {
		    cadastroController.salvarBoleto(boleto);
		    FacesUtil.mensInfo("Informações do Boleto salvo com sucesso!");
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

   
}
