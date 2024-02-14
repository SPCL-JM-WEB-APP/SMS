package account.demo.serviceImpl;

import org.springframework.stereotype.Service;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;

@Service
public class PdfGenerationService {

    public byte[] generatePdfFromHtml(String htmlContent) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(htmlContent);
            renderer.layout();  
            renderer.createPDF(outputStream);
            renderer.finishPDF();
            byte[] pdfBytes = outputStream.toByteArray();
            outputStream.close();
            return pdfBytes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
