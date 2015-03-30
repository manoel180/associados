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

public class BoletoFactory {
    public List<Boleto> showBoleto(Calendar dataVencimento, int qtdParcela) throws IOException {

	// Quem paga o boleto
	Pagador pagador = Pagador.novoPagador().comNome("Oferta Voluntária");

	Banco banco = new BancoDoBrasil();
	List<Boleto> boletos = new ArrayList<Boleto>();

	Boleto boleto;

	for (int i = 0; i <= qtdParcela-1; i++) {
	    Calendar c = dataVencimento;

	    c.add(Calendar.MONTH, i);

	    // Quem emite o boleto
	    Beneficiario beneficiario = Beneficiario
		    .novoBeneficiario()
		    .comNomeBeneficiario(
			    "ASSOCIACAO AMIGOS DE JERUSALEM - ICEJBRASIL")
		    .comAgencia("2905").comCodigoBeneficiario("71905")
		    .comNumeroConvenio("2545630").comCarteira("18")
		    .comNossoNumero(String.valueOf(i));

	    boleto = Boleto
		    .novoBoleto()
		    .comBanco(banco)
		    .comBeneficiario(beneficiario)
		    .comPagador(pagador)
		    .comValorBoleto("100.00")
		    .comNumeroDoDocumento(String.valueOf(i))
		    .comInstrucoes(pagador.getNome())
		    .comLocaisDePagamento("local " + i)
		    .comDatas(
			    Datas.novasDatas()
				    .comDocumento(Calendar.getInstance())
				    .comVencimento(c)
				    .comProcessamento(Calendar.getInstance()));
	    boletos.add(boleto);

	}
	return boletos;
    }

    public void generateLote(Integer quantidade, Calendar dtVencimento)
	    throws IOException {
	List<Boleto> boletosLote = new ArrayList<Boleto>();
	for (int i = 0; i <= quantidade; i++) {
	    boletosLote.addAll(showBoleto(dtVencimento, 12));
	}
	// Mapa para parâmetros
	Map<String, Object> parametros = new HashMap<String, Object>();

	// carrega o caminho físico do arquivo
	String reportPath = FacesUtil.getServletContext().getRealPath(
		"/WEB-INF/jasper/boleto-default.jasper");

	GeradorDeBoleto gerador;
	InputStream templateBoleto = new FileInputStream(reportPath);
	gerador = new GeradorDeBoleto(templateBoleto, parametros, boletosLote);
	byte[] bPDF = gerador.geraPDF();
	GenerateBoleto generateBoleto = new GenerateBoleto();
	generateBoleto.download(bPDF);

    }

}
