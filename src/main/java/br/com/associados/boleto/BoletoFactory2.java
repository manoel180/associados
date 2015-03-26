package br.com.associados.boleto;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Endereco;
import br.com.caelum.stella.boleto.Pagador;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoletoHTML;

public class BoletoFactory2 {
    public void showBoleto() throws IOException {
	Datas datas = Datas.novasDatas().comDocumento(1, 5, 2015)
		.comProcessamento(1, 5, 2015).comVencimento(2, 5, 2015);


	// Quem emite o boleto
	Beneficiario beneficiario = Beneficiario.novoBeneficiario()
		.comNomeBeneficiario("ASSOCIACAO AMIGOS DE JERUSALEM - ICEJBRASIL").comAgencia("2905")
		.comCodigoBeneficiario("71905")
		.comNumeroConvenio("2545630")
		.comCarteira("18")
		.comNossoNumero("9000206");


	// Quem paga o boleto
	Pagador pagador = Pagador.novoPagador().comNome("Oferta Voluntária");

	Banco banco = new BancoDoBrasil();

	Boleto boleto = Boleto
		.novoBoleto()
		.comBanco(banco)
		.comDatas(datas)
		.comBeneficiario(beneficiario)
		.comPagador(pagador)
		.comValorBoleto("100.00")
		.comNumeroDoDocumento("1")
		.comInstrucoes("instrucao 1")
		.comLocaisDePagamento("local 1");

	GeradorDeBoleto gerador = new GeradorDeBoleto(boleto);
	// Para gerar um boleto em PDF
	gerador.geraPDF("BancoDoBrasil.pdf");

	// Para gerar um boleto em PNG
	gerador.geraPNG("BancoDoBrasil.png");

	// Para gerar um array de bytes a partir de um PDF
	byte[] bPDF = gerador.geraPDF();

	// Para gerar um array de bytes a partir de um PNG
	byte[] bPNG = gerador.geraPNG();
	
	GenerateBoleto generateBoleto = new GenerateBoleto();
	generateBoleto.download(bPDF);
    }
}
