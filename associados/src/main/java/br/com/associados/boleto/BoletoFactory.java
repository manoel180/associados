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

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;

import br.com.associados.entities.DadosBoleto;
import br.com.associados.entities.Lote;
import br.com.associados.service.CadastroService;
import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Pagador;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;
import br.com.caelum.stella.boleto.utils.StellaStringUtils;

public class BoletoFactory {

    private CadastroService cadastroController;

    private br.com.associados.entities.Boleto boletoModel;

    Lote lote;

    List<Lote> lotes = new ArrayList<Lote>();

    public List<Boleto> showBoleto(Lote l)
	    throws IOException {

    DadosBoleto dadosBoleto = cadastroController.getDadosBoleto();
    	
	// Quem paga o boleto
	Pagador pagador = Pagador.novoPagador().comNome(dadosBoleto.getNomePagador());

	Banco banco = new BancoDoBrasil();
	List<Boleto> boletos = new ArrayList<Boleto>();

	Boleto boleto;

	for (br.com.associados.entities.Boleto b : l.getBoletos()) {
	    Calendar c = Calendar.getInstance();

	    c.setTime(b.getDtVencimento());

	    //Cedente
	    // Quem emite o boleto
	    Beneficiario beneficiario = Beneficiario
		    .novoBeneficiario()
		    .comNomeBeneficiario(dadosBoleto.getNomeBeneficiario())//"PRIMEIRA IGREJA BATISTA DA RESTAURAÇÃO EM MANAUS")
		    .comAgencia(dadosBoleto.getAgencia())//"2905")
		    .comDigitoAgencia(dadosBoleto.getDigitoAgencia())//"X")
		    .comCodigoBeneficiario(dadosBoleto.getCodigoBeneficiario())//"22234")
		    .comDigitoCodigoBeneficiario(dadosBoleto.getDigitoCodigoBeneficiario())//"8")
		    .comNumeroConvenio(dadosBoleto.getNumeroConvenio())//"2195571")
		    .comCarteira(dadosBoleto.getCarteira())//"18")
		    .comNossoNumero(dadosBoleto.getNumeroConvenio()+StellaStringUtils.leftPadWithZeros(b.getId().toString(), 10));
		    		//"2195571"+StellaStringUtils.leftPadWithZeros(b.getId().toString(), 10));

	    boleto = Boleto
		    .novoBoleto()
		    .comBanco(banco)
		    .comBeneficiario(beneficiario)
		    .comPagador(pagador)
		    .comValorBoleto(b.getValor().toString())
		    .comNumeroDoDocumento(b.getId().toString())
		    .comInstrucoes(pagador.getNome())
		    .comLocaisDePagamento(dadosBoleto.getLocalPagamento()) //"Pagável em qualquer Banco até o vencimento")
		    .comDatas(
			    Datas.novasDatas()
				    .comVencimento(c));
	    boletos.add(boleto);
	 
	}
	return boletos;
    }

    public HttpEntity<byte[]> generateLote(Integer qtdParcela, Integer qtdLote,
	    Date dtVencimento, BigDecimal valor,CadastroService cadastroController) throws IOException {
	this.cadastroController = cadastroController;
	List<Boleto> boletosLote = new ArrayList<Boleto>();
	lotes = new ArrayList<Lote>();
	

	gerarLoteBD(qtdParcela, qtdLote, dtVencimento, valor);
	for(Lote l : lotes){
	    boletosLote.addAll(showBoleto(l));
	}
	// Mapa para parâmetros
	Map<String, Object> parametros = new HashMap<String, Object>();

	// carrega o caminho físico do arquivo
	Resource resource = new ClassPathResource("/jasper/win/boleto-default.jasper");


	GeradorDeBoleto gerador;
	InputStream templateBoleto = new FileInputStream(resource.getFile());
	gerador = new GeradorDeBoleto(templateBoleto, parametros, boletosLote);
	byte[] bPDF = gerador.geraPDF();
	GenerateBoleto generateBoleto = new GenerateBoleto();
	return generateBoleto.download(bPDF);

    }

    private void gerarLoteBD(Integer qtdParcela, Integer qtdLote, 
	    Date dtVencimento, BigDecimal valor) {
	
	lote = new Lote();
	lote.setBoletos(new ArrayList<br.com.associados.entities.Boleto>());
	boletoModel = new br.com.associados.entities.Boleto();
	for (int i = 1; i <= qtdLote; i++) {
	    for (int j = 0; j < qtdParcela; j++) {
		Calendar dt = Calendar.getInstance();
		dt.setTime(dtVencimento);
		dt.add(Calendar.MONTH, j);
		boletoModel.setValor(valor);
		boletoModel.setDtVencimento(dt.getTime());
		lote.getBoletos().add(boletoModel);
		boletoModel.setLote(lote);
		boletoModel = new br.com.associados.entities.Boleto();
	    }
	    lotes.add(lote);
	    lote=new Lote();
	    lote.setBoletos(new ArrayList<br.com.associados.entities.Boleto>());
	}
	saveLote();
    }

    private void saveLote() {
	for (Lote l : lotes) {
	    cadastroController.salvarLote(l);
	}
    }

}
