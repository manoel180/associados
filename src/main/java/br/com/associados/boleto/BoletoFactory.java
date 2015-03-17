package br.com.associados.boleto;

import java.io.File;
import java.io.IOException;

import org.jrimum.bopepo.BancosSuportados;
import org.jrimum.bopepo.Boleto;
import org.jrimum.bopepo.exemplo.Exemplos;
import org.jrimum.bopepo.view.BoletoViewer;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
import org.jrimum.utilix.ClassLoaders;

public class BoletoFactory {
    public void generateBoleto() {
	Titulo titulo = Exemplos.crieTitulo();
	titulo.getContaBancaria().setBanco(
		BancosSuportados.BANCO_DO_BRASIL.create());
	titulo.setNossoNumero("1234567890");

	Boleto boleto = Exemplos.crieBoleto(titulo);

	// Informando o template personalizado:
	File templatePersonalizado = new File(ClassLoaders.getResource(
		"/templates/BoletoTemplatePersonalizacaoSimples.pdf").getFile());
	BoletoViewer boletoViewer = new BoletoViewer(boleto,
		templatePersonalizado);

	File arquivoPdf = boletoViewer
		.getPdfAsFile("MeuBoletoPersonalizado.pdf");

	mostreBoletoNaTela(arquivoPdf);
    }
    private static void mostreBoletoNaTela(File arquivoBoleto) {

        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
        
        try {
                desktop.open(arquivoBoleto);
        } catch (IOException e) {
                e.printStackTrace();
        }
}
}
