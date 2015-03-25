package br.com.associados.boleto;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.jrimum.bopepo.BancosSuportados;
import org.jrimum.bopepo.Boleto;
import org.jrimum.bopepo.exemplo.Exemplos;
import org.jrimum.bopepo.pdf.Files;
import org.jrimum.bopepo.view.BoletoViewer;
import org.jrimum.domkee.financeiro.banco.febraban.Carteira;
import org.jrimum.domkee.financeiro.banco.febraban.Cedente;
import org.jrimum.domkee.financeiro.banco.febraban.ContaBancaria;
import org.jrimum.domkee.financeiro.banco.febraban.NumeroDaConta;
import org.jrimum.domkee.financeiro.banco.febraban.Sacado;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
import org.jrimum.utilix.ClassLoaders;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;

public class BoletoFactory {
    public void generateBoleto() {

	List<Boleto> boletos = new ArrayList<Boleto>();

	ContaBancaria contaBancaria = new ContaBancaria();
	contaBancaria.setBanco(BancosSuportados.BANCO_DO_BRASIL.create());
	contaBancaria.setNumeroDaConta(new NumeroDaConta(1234567)); // Numero da
								    // Conta
	contaBancaria.setCarteira(new Carteira(1)); // Carteira

	Sacado sacado = new Sacado("Fulano");

	Cedente cedente = new Cedente("Empresa");

	Titulo titulo = new Titulo(contaBancaria, sacado, cedente);
	titulo.setContaBancaria(contaBancaria);
	titulo.setNossoNumero("1234567890"); // Nosso Numero
	// titulo.setDataDoDocumento(new Date());
	titulo.setDataDoVencimento(org.jrimum.bopepo.FatorDeVencimento
		.toDate(0));
	titulo.setValor(new BigDecimal(100));
	Boleto boleto = new Boleto(titulo);// Exemplos.crieBoleto(titulo);
	boleto.setDataDeProcessamento(new Date());
	boleto.addTextosExtras("txtFcDataVencimento", "CONTRA APRESENTAÇÃO");
	boleto.addTextosExtras("txtRsDataVencimento", "CONTRA APRESENTAÇÃO");

	// Informando o template personalizado:
	FacesContext facesContext = FacesContext.getCurrentInstance();
	ServletContext servletContext = (ServletContext) facesContext
			.getExternalContext().getContext();
	
	File templatePersonalizado = new File(servletContext
		.getRealPath("BoletoCarne3PorPagina.pdf"));
	// BoletoViewer boletoViewer = new BoletoViewer(boleto,
	// templatePersonalizado);// ,templatePersonalizado);
	boletos.add(boleto);
	boletos.add(boleto);
	boletos.add(boleto);
	boletos.add(boleto);
	boletos.add(boleto);
	boletos.add(boleto);
	// Agrupando os boletos em apenas uma página
	File boletosPorPagina = groupInPages(boletos, "Carne3PorPagina.pdf",
		templatePersonalizado);

	// Exemplos.mostreBoletoNaTela(boletosPorPagina);
	download(boletosPorPagina);
    }

    private static File groupInPages(List<Boleto> boletos, String filePath,
	    File templatePersonalizado) {

	File arq = null;
	BoletoViewer boletoViewer = new BoletoViewer(boletos.get(0));
	boletoViewer.setTemplate(templatePersonalizado);

	List<byte[]> boletosEmBytes = new ArrayList<byte[]>(boletos.size());

	for (Boleto bop : boletos) {
	    boletosEmBytes.add(boletoViewer.setBoleto(bop).getPdfAsByteArray());
	}

	try {

	    arq = Files
		    .bytesToFile(filePath, mergeFilesInPages(boletosEmBytes));

	} catch (Exception e) {
	    throw new IllegalStateException(
		    "Erro durante geração do PDF! Causado por "
			    + e.getLocalizedMessage(), e);
	}

	return arq;
    }

    public static byte[] mergeFilesInPages(List<byte[]> pdfFilesAsByteArray)
	    throws DocumentException, IOException {

	Document document = new Document();
	ByteArrayOutputStream byteOS = new ByteArrayOutputStream();

	PdfWriter writer = PdfWriter.getInstance(document, byteOS);

	document.open();

	PdfContentByte cb = writer.getDirectContent();
	float positionAnterior = 0;

	// Para cada arquivo da lista, cria-se um PdfReader, responsável por ler
	// o arquivo PDF e recuperar informações dele.
	for (byte[] pdfFile : pdfFilesAsByteArray) {

	    PdfReader reader = new PdfReader(pdfFile);

	    // Faz o processo de mesclagem por página do arquivo, começando pela
	    // de número 1.
	    for (int i = 1; i <= reader.getNumberOfPages(); i++) {

		float documentHeight = cb.getPdfDocument().getPageSize()
			.getHeight();

		// Importa a página do PDF de origem
		PdfImportedPage page = writer.getImportedPage(reader, i);
		float pagePosition = positionAnterior;

		/*
		 * Se a altura restante no documento de destino form menor que a
		 * altura do documento, cria-se uma nova página no documento de
		 * destino.
		 */
		if ((documentHeight - positionAnterior) <= page.getHeight()) {
		    document.newPage();
		    pagePosition = 0;
		    positionAnterior = 0;
		}

		// Adiciona a página ao PDF destino
		cb.addTemplate(page, 0, pagePosition);

		positionAnterior += page.getHeight();
	    }
	}

	byteOS.flush();
	document.close();

	byte[] arquivoEmBytes = byteOS.toByteArray();
	byteOS.close();

	return arquivoEmBytes;
    }

    private byte[] fileToByte(File file) {
	FileInputStream fileInputStream = null;

	byte[] bFile = new byte[(int) file.length()];

	try {
	    // convert file into array of bytes
	    fileInputStream = new FileInputStream(file);
	    fileInputStream.read(bFile);
	    fileInputStream.close();

	    for (int i = 0; i < bFile.length; i++) {
		System.out.print((char) bFile[i]);
	    }

	    System.out.println("Done");
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return bFile;

    }
    public String download2(){
        
	Titulo titulo = Exemplos.crieTitulo();
        titulo.getContaBancaria().setBanco(BancosSuportados.BANCO_DO_BRASIL.create());
        titulo.setNossoNumero("1234567890");
        
        Boleto boleto = Exemplos.crieBoleto(titulo);
        
        //Informando o template personalizado:
        //File templatePersonalizado = new File(ClassLoaders.getResource("/templates/BoletoTemplatePersonalizacaoSimples.pdf").getFile());
        BoletoViewer boletoViewer = new BoletoViewer(boleto);//, templatePersonalizado);

        //File arquivoPdf = boletoViewer.getPdfAsFile("MeuBoletoPersonalizado.pdf");

        byte[] pdfAsBytes = boletoViewer.getPdfAsByteArray();

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

        try {
                                
             response.setContentType("application/pdf");
             response.setHeader("Content-Disposition", "attachment; filename=boleto.pdf");

             OutputStream output = response.getOutputStream();
             output.write(pdfAsBytes);
             response.flushBuffer();

             FacesContext.getCurrentInstance().responseComplete();

        } catch (IOException e) {
                e.printStackTrace();
        }
        
        return null;
}

    public void download(File boletosPorPagina) {

	byte[] pdfAsBytes = fileToByte(boletosPorPagina);// getPdfAsByteArray();

	try {
	    if (pdfAsBytes == null)
		throw new Exception("Array de bytes nulo.");

	    FacesContext facesContext = FacesContext.getCurrentInstance();
	    HttpServletResponse response = (HttpServletResponse) facesContext
		    .getExternalContext().getResponse();
	    response.setHeader("Content-Disposition",
		    "attachment; filename=boleto.pdf;");
	    response.setContentLength(pdfAsBytes.length);
	    ServletOutputStream ouputStream = response.getOutputStream();
	    ouputStream.write(pdfAsBytes, 0, pdfAsBytes.length);
	    facesContext.responseComplete();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
    // HttpServletResponse response = (HttpServletResponse) FacesContext
    // .getCurrentInstance().getExternalContext().getResponse();
    //
    // try {
    //
    // response.setContentType("application/pdf");
    // response.setHeader("Content-Disposition",
    // "attachment; filename=boleto.pdf");
    //
    // OutputStream output = response.getOutputStream();
    // output.write(pdfAsBytes);
    // response.flushBuffer();
    //
    // FacesContext.getCurrentInstance().responseComplete();
    //
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    //
    // return null;
    // }
}
