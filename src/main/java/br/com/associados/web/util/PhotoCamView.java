package br.com.associados.web.util;

import java.io.File;
import java.io.IOException;

import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;

import org.primefaces.event.CaptureEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("photoCamView")
@Scope("request")
public class PhotoCamView {

        private String filename;

        private String getRandomImageName() {
                int i = (int) (Math.random() * 10000000);

                return String.valueOf(i);
        }

        public String getFilename() {
                return filename;
        }

        public void oncapture(CaptureEvent captureEvent) {
                filename = getRandomImageName();
                byte[] data = captureEvent.getData();

                ServletContext servletContext = (ServletContext) FacesContext
                                .getCurrentInstance().getExternalContext()
                                .getContext();
                String newFileName = servletContext.getRealPath("")
                                + File.separator + "resources" + File.separator
                                + "photos"
                                + File.separator
                                + filename + ".jpeg";

                FileImageOutputStream imageOutput;
                try {
                        imageOutput = new FileImageOutputStream(new File(
                                        newFileName));
                        imageOutput.write(data, 0, data.length);
                        imageOutput.close();
                } catch (IOException e) {
                        throw new FacesException(
                                        "Error in writing captured image.", e);
                }
        }
}
