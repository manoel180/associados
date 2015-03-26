package br.com.associados.boleto;

import java.io.IOException;
import java.io.OutputStream;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

public class GenerateBoleto {
    public String download(byte[] pdfAsBytes) {


	HttpServletResponse response = (HttpServletResponse) FacesContext
		.getCurrentInstance().getExternalContext().getResponse();

	try {

	    response.setContentType("application/pdf");
	    response.setHeader("Content-Disposition",
		    "attachment; filename=boleto.pdf");

	    OutputStream output = response.getOutputStream();
	    output.write(pdfAsBytes);
	    response.flushBuffer();

	    FacesContext.getCurrentInstance().responseComplete();

	} catch (IOException e) {
	    e.printStackTrace();
	}

	return null;
    }
}
