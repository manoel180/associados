package br.com.associados.web.mbeans;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.lindbergframework.spring.scope.AccessScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.associados.boleto.BoletoFactory;
import br.com.associados.controller.CadastroController;
import br.com.associados.web.util.FacesUtil;

@Component("mBeanBoleto")
@AccessScoped
public class MBeanBoleto extends mBeanGerneric {

    private BoletoFactory boletoFactory;

    @Autowired
    private CadastroController cadastroController;

    private Integer qtdParcela;

    private Integer qtdLote;

    private Date dtVencimento;

    @PostConstruct
    public void init() {
	poupalateCombos();
    }

    private void poupalateCombos() {

    }

    public void gerarBoleto() {
	boletoFactory = new BoletoFactory();
	// try {
	// boletoFactory.generateLote(1, dtVencimento);
	//
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
    }

    public void gerarLote() {
	boletoFactory = new BoletoFactory();
	try {
	    boletoFactory.generateLote(qtdParcela, qtdLote, dtVencimento);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void salvar() {
	try {
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

    /**
     * @return the qtdParcela
     */
    public Integer getQtdParcela() {
	return qtdParcela;
    }

    /**
     * @param qtdParcela
     *            the qtdParcela to set
     */
    public void setQtdParcela(Integer qtdParcela) {
	this.qtdParcela = qtdParcela;
    }

    /**
     * @return the qtdLote
     */
    public Integer getQtdLote() {
	return qtdLote;
    }

    /**
     * @param qtdLote
     *            the qtdLote to set
     */
    public void setQtdLote(Integer qtdLote) {
	this.qtdLote = qtdLote;
    }

    /**
     * @return the dtVencimento
     */
    public Date getDtVencimento() {
	return dtVencimento;
    }

    /**
     * @param dtVencimento
     *            the dtVencimento to set
     */
    public void setDtVencimento(Date dtVencimento) {
	this.dtVencimento = dtVencimento;
    }

}
