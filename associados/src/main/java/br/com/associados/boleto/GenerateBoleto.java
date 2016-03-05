package br.com.associados.boleto;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class GenerateBoleto {
    public HttpEntity<byte[]> download(byte[] pdfAsBytes) {

    	byte[] documentBody = pdfAsBytes; 
    	HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "pdf"));
        header.set("Content-Disposition",
                       "attachment; filename=boleto.pdf");
        header.setContentLength(documentBody.length);
System.out.println("terminou de gerar o boleto");
        return new HttpEntity<byte[]>(documentBody, header);

    }
}
