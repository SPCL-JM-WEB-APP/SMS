package com.springjava.serviceImpl;

import org.springframework.stereotype.Service;

import org.xhtmlrenderer.pdf.ITextRenderer;

import com.springjava.entity.Detail_entity;
import com.springjava.entity.Fees_Collection_entity;
import jakarta.servlet.http.HttpServletResponse;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class PdfGenerationService {
	public static byte[] generatePdfFromHtml(String htmlContent) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(htmlContent);
            renderer.layout();
            renderer.createPDF(outputStream);
            renderer.finishPDF();
            return outputStream.toByteArray();
        } catch (Exception e) {
            // Log any exceptions that occur during PDF generation
            e.printStackTrace();
            return null;
        }
    }
	

	    public static String generateHtmlFromData(List<Detail_entity> detailsList, List<Fees_Collection_entity> feesList) {
	        StringBuilder htmlBuilder = new StringBuilder();
	        htmlBuilder.append("<!DOCTYPE html>");
	        htmlBuilder.append("<html>");
	        htmlBuilder.append("<head><title>Invoice</title></head>");
	        htmlBuilder.append("<body>");
	        
	        // Generating HTML for Details
	        htmlBuilder.append("<h2>Fee Type</h2>");
	        for (Detail_entity detail : detailsList) {
	            htmlBuilder.append("<div>");
	            htmlBuilder.append("<p>").append("Sr Number: ").append(detail.getSr_Number()).append("</p>");
	            htmlBuilder.append("<p>").append("Fee Title: ").append(detail.getFee_Title()).append("</p>");
	            htmlBuilder.append("<p>").append("Fee Type: ").append(detail.getFee_Type()).append("</p>");
	            htmlBuilder.append("<p>").append("Amount Payable: ").append(detail.getAmount_Payable()).append("</p>");
	            htmlBuilder.append("<p>").append("Amount Paid: ").append(detail.getAmount_Paid()).append("</p>");
	            htmlBuilder.append("<p>").append("Amount Paying: ").append(detail.getAmount_Paying()).append("</p>");
	            htmlBuilder.append("<p>").append("Receipt_Number: ").append(detail.getReceipt_Number()).append("</p>");

	            htmlBuilder.append("</div>");
	        }

	        // Generating HTML for Fees Collection
	        htmlBuilder.append("<h2>Student Information</h2>");
	        for (Fees_Collection_entity fee : feesList) {
	            htmlBuilder.append("<div>");
	            htmlBuilder.append("<p>").append("Student ID: ").append(fee.getStudent_id()).append("</p>");
	            htmlBuilder.append("<p>").append("Student Name: ").append(fee.getStudent_name()).append("</p>");
	            htmlBuilder.append("<p>").append("Standard: ").append(fee.getStandard()).append("</p>");
	            htmlBuilder.append("<p>").append("Division: ").append(fee.getDivision()).append("</p>");
	            htmlBuilder.append("<p>").append("Previous Fees: ").append(fee.getPrevious_Fees()).append("</p>");
	            htmlBuilder.append("<p>").append("Paid Fees: ").append(fee.getPaid_Fees()).append("</p>");
	            htmlBuilder.append("<p>").append("Remaining Fees: ").append(fee.getRemaining_Fees()).append("</p>");
	            htmlBuilder.append("<p>").append("Total Fee: ").append(fee.getTotal_Fee()).append("</p>");
	            htmlBuilder.append("</div>");
	        }
	     // Append payment mode selection
	     //   htmlBuilder.append("<h2>Payment Mode</h2>");
	       // htmlBuilder.append("<p>").append("Payment Mode: ").append("value from dropdown").append("</p>");


	        htmlBuilder.append("</body>");
	        htmlBuilder.append("</html>");
	        return htmlBuilder.toString();
	    }


		public static void generatePdfFromHtml(String htmlContent, HttpServletResponse response) {
			// TODO Auto-generated method stub
			
		}


		public static String generateHtmlForStudent(Fees_Collection_entity student, List<Detail_entity> detailsList) {
			// TODO Auto-generated method stub
			return null;
		}
	
	
	
	
	
//	 public static String generateHtmlFromData(List<Detail_entity> detailsList) {
//	        // Create a StringBuilder to construct the HTML content
//	        StringBuilder htmlBuilder = new StringBuilder();
//	        // Start HTML document
//	        htmlBuilder.append("<!DOCTYPE html>");
//	        htmlBuilder.append("<html>");
//	        htmlBuilder.append("<head><title>Invoice</title></head>");
//	        htmlBuilder.append("<body>");
//	        // Loop through the detailsList and generate HTML content
//	        for (Detail_entity detail : detailsList) {
//	            // Example: Append detail's content to HTML
//	            htmlBuilder.append("<div>");
//	            htmlBuilder.append("<p>").append("Sr Number: ").append(detail.getSr_Number()).append("</p>");
//	            htmlBuilder.append("<p>").append("Fee Title: ").append(detail.getFee_Title()).append("</p>");
//	            htmlBuilder.append("<p>").append("Fee Type: ").append(detail.getFee_Type()).append("</p>");
//	            htmlBuilder.append("<p>").append("Amount Payable: ").append(detail.getAmount_Payable()).append("</p>");
//	            htmlBuilder.append("<p>").append("Amount Paid: ").append(detail.getAmount_Paid()).append("</p>");
//	            htmlBuilder.append("<p>").append("Amount Paying: ").append(detail.getAmount_Paying()).append("</p>");
//	            htmlBuilder.append("</div>");
//	        }
//	        // End HTML document
//	        htmlBuilder.append("</body>");
//	        htmlBuilder.append("</html>");
//	        return htmlBuilder.toString();
//	    }
	}