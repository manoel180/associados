package br.com.associados.boleto;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.associados.web.util.FacesUtil;
import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Pagador;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;

public class BoletoFactory2 {
    public void showBoleto() throws IOException {
	Datas datas = Datas.novasDatas().comDocumento(26, 3, 2015)
		.comProcessamento(26, 3, 2015).comVencimento(26, 3, 2015);


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
	
	//Mapa para parâmetros
	Map<String, Object> parametros = new HashMap<String, Object>();

	//carrega o caminho físico do arquivo
	String reportPath = FacesUtil.getServletContext().getRealPath("/WEB-INF/jasper/boleto-default.jasper");

	//carrega o conteúdo do arquivo em um InputStream
	InputStream templateBoleto = new FileInputStream(reportPath);

	// passa para o gerador de boleto os dados do template no construtor, 
	// junto com o mapa com os parâmetros, além dos dados dos boletos
	//GeradorDeBoletoHtml new GeradorDeBoletoHTML(templateBoleto,parametros,boleto);
	GeradorDeBoleto gerador;
	List<Boleto> boletos = new ArrayList<Boleto>();
	for(int i=0; i<10; i++){	    
	     boletos.add(boleto);
	}
	gerador = new GeradorDeBoleto(templateBoleto, parametros, boletos);
	// Para gerar um boleto em PDF
	//gerador.geraPDF("BancoDoBrasil.pdf");

	// Para gerar um boleto em PNG
	//gerador.geraPNG("BancoDoBrasil.png");

	// Para gerar um array de bytes a partir de um PDF
	byte[] bPDF = gerador.geraPDF();

	// Para gerar um array de bytes a partir de um PNG
	//byte[] bPNG = gerador.geraPNG();
	
	GenerateBoleto generateBoleto = new GenerateBoleto();
	generateBoleto.download(bPDF);
    }

    public void generateLote(Integer quantidade, Calendar dtVencimento) {
	// TODO Auto-generated method stub
	
    }
}
