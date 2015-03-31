package br.com.associados.boleto;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.associados.controller.CadastroController;
import br.com.associados.model.Lote;
import br.com.associados.web.util.FacesUtil;
import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Pagador;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;
import br.com.caelum.stella.boleto.utils.StellaStringUtils;
import br.com.caelum.stella.format.LeftSideZerosFormatter;

public class BoletoFactory {

    private CadastroController cadastroController;

    private br.com.associados.model.Boleto boletoModel;

    Lote lote;

    List<Lote> lotes = new ArrayList<Lote>();

    public List<Boleto> showBoleto(Lote l)
	    throws IOException {

	// Quem paga o boleto
	Pagador pagador = Pagador.novoPagador().comNome("Oferta Voluntária");

	Banco banco = new BancoDoBrasil();
	List<Boleto> boletos = new ArrayList<Boleto>();

	Boleto boleto;

	for (br.com.associados.model.Boleto b : l.getBoletos()) {
	    Calendar c = Calendar.getInstance();

	    c.setTime(b.getDtVencimento());

	    //Cedente
	    // Quem emite o boleto
	    Beneficiario beneficiario = Beneficiario
		    .novoBeneficiario()
		    .comNomeBeneficiario(
			    "ASSOCIACAO AMIGOS DE JERUSALEM - ICEJBRASIL")
		    .comAgencia("2905").comCodigoBeneficiario("71905")
		    .comNumeroConvenio("2545630").comCarteira("18")
		    .comNossoNumero("2545630"+StellaStringUtils.leftPadWithZeros(b.getId().toString(), 10));

	    boleto = Boleto
		    .novoBoleto()
		    .comBanco(banco)
		    .comBeneficiario(beneficiario)
		    .comPagador(pagador)
		    .comValorBoleto(b.getValor().toString())
		    .comNumeroDoDocumento(b.getId().toString())
		    .comInstrucoes(pagador.getNome())
		    .comLocaisDePagamento(
			    "Pagável em qualquer Banco até o vencimento")
		    .comDatas(
			    Datas.novasDatas()
				    .comDocumento(Calendar.getInstance())
				    .comVencimento(c)
				    .comProcessamento(Calendar.getInstance()));
	    boletos.add(boleto);
	 
	}
	return boletos;
    }

    public void generateLote(Integer qtdParcela, Integer qtdLote,
	    Date dtVencimento, BigDecimal valor,CadastroController cadastroController) throws IOException {
	this.cadastroController = cadastroController;
	List<Boleto> boletosLote = new ArrayList<Boleto>();
	lotes = new ArrayList<Lote>();
//	for (int i = 1; i <= qtdLote; i++) {
//	    boletosLote.addAll(showBoleto(dtVencimento, qtdParcela));
//	}
	gerarLoteBD(qtdParcela, qtdLote, dtVencimento, valor);
	for(Lote l : lotes){
	    boletosLote.addAll(showBoleto(l));
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

    private void gerarLoteBD(Integer qtdParcela, Integer qtdLote, 
	    Date dtVencimento, BigDecimal valor) {
	Calendar dt = Calendar.getInstance();
	dt.setTime(dtVencimento);
	lote = new Lote();
	lote.setBoletos(new ArrayList<>());
	boletoModel = new br.com.associados.model.Boleto();
	for (int i = 1; i <= qtdLote; i++) {
	    for (int j = 1; j <= qtdParcela; j++) {
		boletoModel.setValor(valor);
		boletoModel.setDtVencimento(dt.getTime());
		lote.getBoletos().add(boletoModel);
		dt.add(Calendar.MONTH, i);
		boletoModel = new br.com.associados.model.Boleto();
	    }
	    lotes.add(lote);
	    lote=new Lote();
	    lote.setBoletos(new ArrayList<>());
	}
	saveLote();
    }

    private void saveLote() {
	for (Lote l : lotes) {
	    cadastroController.salvarLote(l);
	}
    }

}
