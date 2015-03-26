package br.com.associados.boleto;


public class BoletoFactory {
//    public void generateBoleto() {
//
//	List<Boleto> boletos = new ArrayList<Boleto>();
//
//	ContaBancaria contaBancaria = new ContaBancaria();
//	contaBancaria.setBanco(BancosSuportados.BANCO_DO_BRASIL.create());
//	contaBancaria.setAgencia(new Agencia(2905));
//	contaBancaria.setNumeroDaConta(new NumeroDaConta(2545630)); // Numero da
//								    // Conta
//	contaBancaria.setCarteira(new Carteira(18)); // Carteira
//	//contaBancaria.setModalidade(new Modalidade("-019"));
//	
//
//	Sacado sacado = new Sacado("Oferta Voluntária");
//
//	Cedente cedente = new Cedente("ASSOCIACAO AMIGOS DE JERUSALEM - ICEJBRASIL");
//	
//
//	Titulo titulo = new Titulo(contaBancaria, sacado, cedente);
//	titulo.setNossoNumero("25456300000000014"); // Nosso Numero
//	// titulo.setDataDoDocumento(new Date());
//	Calendar calendar = Calendar.getInstance();
//	calendar.set(2015, 04, 27);
//	Date date = calendar.getTime();
//	titulo.setDataDoVencimento(date );
//	titulo.setValor(new BigDecimal(100));
//	Boleto boleto = new Boleto(titulo);// Exemplos.crieBoleto(titulo);
//	boleto.setDataDeProcessamento(new Date());
//	boleto.setLocalPagamento("Pagável em qualquer Banco até o Vencimento.");
//	
////	boleto.addTextosExtras("txtFcDataVencimento", "CONTRA APRESENTAÇÃO");
////	boleto.addTextosExtras("txtRsDataVencimento", "CONTRA APRESENTAÇÃO");
//	
//
//	// Informando o template personalizado:
//	FacesContext facesContext = FacesContext.getCurrentInstance();
//	ServletContext servletContext = (ServletContext) facesContext
//			.getExternalContext().getContext();
//	
//	File templatePersonalizado = new File(servletContext
//		.getRealPath("/resources/BoletoCarne3PorPagina.pdf"));
//	// BoletoViewer boletoViewer = new BoletoViewer(boleto,
//	// templatePersonalizado);// ,templatePersonalizado);
//	for (int i = 0 ; i< 1; i++) {
//	    boletos.add(boleto);
//	}
//	// Agrupando os boletos em apenas uma página
//	File boletosPorPagina = groupInPages(boletos, "Carne3PorPagina.pdf",
//		templatePersonalizado);
//
//	// Exemplos.mostreBoletoNaTela(boletosPorPagina);
//	download(boletosPorPagina);
//    }
//
//    private static File groupInPages(List<Boleto> boletos, String filePath,
//	    File templatePersonalizado) {
//
//	File arq = null;
//	BoletoViewer boletoViewer = new BoletoViewer(boletos.get(0));
//	boletoViewer.setTemplate(templatePersonalizado);
//
//	List<byte[]> boletosEmBytes = new ArrayList<byte[]>(boletos.size());
//
//	for (Boleto bop : boletos) {
//	    boletosEmBytes.add(boletoViewer.setBoleto(bop).getPdfAsByteArray());
//	}
//
//	try {
//
//	    arq = Files
//		    .bytesToFile(filePath, mergeFilesInPages(boletosEmBytes));
//
//	} catch (Exception e) {
//	    throw new IllegalStateException(
//		    "Erro durante geração do PDF! Causado por "
//			    + e.getLocalizedMessage(), e);
//	}
//
//	return arq;
//    }
//
//    public static byte[] mergeFilesInPages(List<byte[]> pdfFilesAsByteArray)
//	    throws DocumentException, IOException {
//
//	Document document = new Document();
//	ByteArrayOutputStream byteOS = new ByteArrayOutputStream();
//
//	PdfWriter writer = PdfWriter.getInstance(document, byteOS);
//
//	document.open();
//
//	PdfContentByte cb = writer.getDirectContent();
//	float positionAnterior = 0;
//
//	// Para cada arquivo da lista, cria-se um PdfReader, responsável por ler
//	// o arquivo PDF e recuperar informações dele.
//	for (byte[] pdfFile : pdfFilesAsByteArray) {
//
//	    PdfReader reader = new PdfReader(pdfFile);
//
//	    // Faz o processo de mesclagem por página do arquivo, começando pela
//	    // de número 1.
//	    for (int i = 1; i <= reader.getNumberOfPages(); i++) {
//
//		float documentHeight = cb.getPdfDocument().getPageSize()
//			.getHeight();
//
//		// Importa a página do PDF de origem
//		PdfImportedPage page = writer.getImportedPage(reader, i);
//		float pagePosition = positionAnterior;
//
//		/*
//		 * Se a altura restante no documento de destino form menor que a
//		 * altura do documento, cria-se uma nova página no documento de
//		 * destino.
//		 */
//		if ((documentHeight - positionAnterior) <= page.getHeight()) {
//		    document.newPage();
//		    pagePosition = 0;
//		    positionAnterior = 0;
//		}
//
//		// Adiciona a página ao PDF destino
//		cb.addTemplate(page, 0, pagePosition);
//
//		positionAnterior += page.getHeight();
//	    }
//	}
//
//	byteOS.flush();
//	document.close();
//
//	byte[] arquivoEmBytes = byteOS.toByteArray();
//	byteOS.close();
//
//	return arquivoEmBytes;
//    }
//
//    private byte[] fileToByte(File file) {
//	FileInputStream fileInputStream = null;
//
//	byte[] bFile = new byte[(int) file.length()];
//
//	try {
//	    // convert file into array of bytes
//	    fileInputStream = new FileInputStream(file);
//	    fileInputStream.read(bFile);
//	    fileInputStream.close();
//
//	    for (int i = 0; i < bFile.length; i++) {
//		System.out.print((char) bFile[i]);
//	    }
//
//	    System.out.println("Done");
//	} catch (Exception e) {
//	    e.printStackTrace();
//	}
//	return bFile;
//
//    }
//    public String download2(){
//        
//	Titulo titulo = Exemplos.crieTitulo();
//        titulo.getContaBancaria().setBanco(BancosSuportados.BANCO_DO_BRASIL.create());
//        titulo.setNossoNumero("1234567890");
//        
//        Boleto boleto = Exemplos.crieBoleto(titulo);
//        
//        //Informando o template personalizado:
//        //File templatePersonalizado = new File(ClassLoaders.getResource("/templates/BoletoTemplatePersonalizacaoSimples.pdf").getFile());
//        BoletoViewer boletoViewer = new BoletoViewer(boleto);//, templatePersonalizado);
//
//        //File arquivoPdf = boletoViewer.getPdfAsFile("MeuBoletoPersonalizado.pdf");
//
//        byte[] pdfAsBytes = boletoViewer.getPdfAsByteArray();
//
//        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//
//        try {
//                                
//             response.setContentType("application/pdf");
//             response.setHeader("Content-Disposition", "attachment; filename=boleto.pdf");
//
//             OutputStream output = response.getOutputStream();
//             output.write(pdfAsBytes);
//             response.flushBuffer();
//
//             FacesContext.getCurrentInstance().responseComplete();
//
//        } catch (IOException e) {
//                e.printStackTrace();
//        }
//        
//        return null;
//}
//
//    public void download(File boletosPorPagina) {
//
//	byte[] pdfAsBytes = fileToByte(boletosPorPagina);// getPdfAsByteArray();
//
//	try {
//	    if (pdfAsBytes == null)
//		throw new Exception("Array de bytes nulo.");
//
//	    FacesContext facesContext = FacesContext.getCurrentInstance();
//	    HttpServletResponse response = (HttpServletResponse) facesContext
//		    .getExternalContext().getResponse();
//	    response.setHeader("Content-Disposition",
//		    "attachment; filename=boleto.pdf;");
//	    response.setContentLength(pdfAsBytes.length);
//	    ServletOutputStream ouputStream = response.getOutputStream();
//	    ouputStream.write(pdfAsBytes, 0, pdfAsBytes.length);
//	    facesContext.responseComplete();
//	} catch (IOException e) {
//	    // TODO Auto-generated catch block
//	    e.printStackTrace();
//	} catch (Exception e) {
//	    // TODO Auto-generated catch block
//	    e.printStackTrace();
//	}
//    }
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
