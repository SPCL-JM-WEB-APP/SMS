
package com.springjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


import org.springframework.ui.Model;

import com.springjava.dto.Detail_Dao;
import com.springjava.dto.Fees_Collection_Dao;
import com.springjava.entity.Detail_entity;
import com.springjava.entity.Fees_Collection_entity;
import com.springjava.serviceImpl.AccountServiceImpl;
import com.springjava.serviceImpl.PdfGenerationService;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;



@Controller
//@RequestMapping("/generatePDF")

public class AccountController{
	
	@Autowired
    private PdfGenerationService pdfGenerationService;

	
     @Autowired
    private Fees_Collection_Dao fees;
     @Autowired

	private final  AccountServiceImpl service;
	
	@Autowired
	private Detail_Dao detailsdao;
	 
	@Autowired
    public AccountController(AccountServiceImpl service, Detail_Dao detailsdao, Fees_Collection_Dao fees ) {
        this.service = service;
        this.fees=fees;
        this.detailsdao=detailsdao;
	}
	  @PostMapping("/invoice")
	  public String studentSearch(@RequestParam int Student_id, Model model) {
	      Optional<Fees_Collection_entity> optionalStudent = service.findById(Student_id);
	      Fees_Collection_entity student = optionalStudent.orElse(null);
	      if (student != null) {
	          model.addAttribute("student", student);
	      } else {
	          model.addAttribute("error", "Student not found");
	      }
	      return "invoice";
	  }
		 
		 
	  @GetMapping("/invoice")
	    public String showFee(Model model) {
	        // Fetch all details and fees from the database
	        Iterable<Detail_entity> details = detailsdao.findAll();
	        Iterable<Fees_Collection_entity> students = fees.findAll();

	        // Add details and students to the model
	        model.addAttribute("invoice", details);
	        model.addAttribute("students", students);

	        // Add a new Detail_entity object to the model for form submission
	        model.addAttribute("newFee", new Detail_entity());

	        return "invoice";
	    }

		 
//		 @PostMapping("/addFee")
//		 public String addFee(@ModelAttribute("newFee") Detail_entity entity) {
//			// feeList.add(detail);
//		        service.saveEntity(entity);
//	 
//			 return "redirect:/invoice";
//		 }
		 @PostMapping("/addFee")
		 public String addFee(@ModelAttribute("newFee") Detail_entity entity, Model model) {
			 String receiptNumber = generateReceiptNumber();

		        entity.setReceipt_Number(receiptNumber);		   

		        service.saveEntity(entity);
		     
		     // Fetch student information again after adding the fee
		     List<Detail_entity> invoice = service.getAllDetails();
		     List<Fees_Collection_entity> students = service.getAllStudents();
		     
		     // Add student information to the model
		     model.addAttribute("student", students);
		     model.addAttribute("invoice", invoice);
		     
		     return "redirect:/invoice";
		 }

		 private String generateReceiptNumber() {
		        // Get current date/time
		        LocalDateTime now = LocalDateTime.now();

		        // Format the date/time
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
		        String formattedDateTime = now.format(formatter);

		        // Concatenate formatted date/time with a prefix
		        return "RCPT" + formattedDateTime;
		    }


		 @GetMapping("/removeFee")
		 public String removeFee(@RequestParam int index) {
		     service.removeFee(index);
		     return "redirect:/invoice"; // Redirect to the invoice page or any other page
		 }
		 
		 
		 
		 @GetMapping("/invoiceform")
		    public String showInvoiceForm(Model model) {
		        // Fetch all details and fees from the database
		        Iterable<Detail_entity> details = detailsdao.findAll();
		        Iterable<Fees_Collection_entity> students = fees.findAll();

		        // Add details and students to the model
		        model.addAttribute("invoice", details);
		        model.addAttribute("students", students);

		        return "invoiceform";
		    }
		 
		 @GetMapping("/student/{Student_id}")
		    public String displayStudent(@PathVariable("Student_id") int Student_id, Model model) {
		        Optional<Fees_Collection_entity> optionalStudent = fees.findById(Student_id);
		        if (optionalStudent.isPresent()) {
		            Fees_Collection_entity student = optionalStudent.get();
		            model.addAttribute("student", student);
		            List<Detail_entity> entity = service.getAllDetails();
					 List<Fees_Collection_entity> student1= service.getAllStudents();
						 model.addAttribute("invoice",entity);
						  model.addAttribute("student", student);
				     	 model.addAttribute("newFee",new Detail_entity());
		            return "invoiceform"; //
		        } else {
		            model.addAttribute("error", "Student not found");
		            return "error"; //
		        }
		  
		      
				  
		    }
		  

		 @GetMapping("/generatePDF")
		 public ResponseEntity<byte[]> generatePDF() {
		     try {
		         List<Detail_entity> detailsList = detailsdao.findAll();
		         List<Fees_Collection_entity> feesList = fees.findAll();

		         String htmlContent = PdfGenerationService.generateHtmlFromData(detailsList, feesList);
		         byte[] pdfBytes = PdfGenerationService.generatePdfFromHtml(htmlContent);

		         HttpHeaders headers = new HttpHeaders();
		         headers.setContentType(MediaType.APPLICATION_PDF);
		         headers.setContentDispositionFormData("inline", "invoice.pdf");

		         return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
		     } catch (Exception e) {
		         e.printStackTrace();
		         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		     }
		 }

}
				 
//		 @GetMapping("/generatePdf")
//		    public String generatePdf() {
//		        // Get your data from the database
//		        List<Fees_Collection_entity> feescollectionentityList = fetchDataFromDatabase();
//
//		        // Generate HTML from the data
//		        String htmlContent = htmlGenerationService.generateHtmlFromData(feescollectionentityList);
//
//		        // Use your PDF generation service to create a PDF from the HTML content
//		        byte[] pdfBytes = pdfGenerationService.generatePdfFromHtml(htmlContent);
//
//		        // Return a response or perform further actions
//		        return "pdfGeneratedSuccessfully";
//		    }
//		private List<Fees_Collection_entity> fetchDataFromDatabase() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		    // Method to fetch data from the database
//		    
//		
//		 

		 
		 
		 
		 





