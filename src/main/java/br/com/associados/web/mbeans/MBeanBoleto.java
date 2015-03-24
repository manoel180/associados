package br.com.associados.web.mbeans;

import javax.annotation.PostConstruct;

import org.lindbergframework.spring.scope.AccessScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.associados.boleto.BoletoFactory;
import br.com.associados.controller.CadastroController;
import br.com.associados.model.Boleto;
import br.com.associados.web.util.FacesUtil;

@Component("mBeanBoleto")
@AccessScoped
public class MBeanBoleto extends mBeanGerneric{

        private Boleto boleto;
        private BoletoFactory boletoFactory;

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
		   // cadastroController.salvarBoleto(boleto);
		    boletoFactory = new BoletoFactory();
		    boletoFactory.generateBoleto();
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
