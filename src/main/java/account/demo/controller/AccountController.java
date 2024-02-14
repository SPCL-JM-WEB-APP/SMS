
package account.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import account.demo.entity.Detail_entity;
import account.demo.entity.Fees_Collection_entity;
import account.demo.serviceImpl.AccountServiceImpl;
import account.demo.serviceImpl.PdfGenerationService;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import org.springframework.core.io.ClassPathResource;




@Controller
//@RequestMapping("/generatePDF")

public class AccountController{
	
	@Autowired
    private PdfGenerationService pdfGenerationService;


	private final  AccountServiceImpl service;
	 
	@Autowired
    public AccountController(AccountServiceImpl service) {
        this.service = service;
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
		 List<Detail_entity> entity = service.getAllDetails();
		 List<Fees_Collection_entity> student = service.getAllStudents(); // Fetch student information

			 
			 model.addAttribute("invoice",entity);
			  model.addAttribute("student", student); // Add student information to the model

			 
	     	 model.addAttribute("newFee",new Detail_entity());
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
		     service.saveEntity(entity);
		     
		     // Fetch student information again after adding the fee
		     List<Detail_entity> invoice = service.getAllDetails();
		     List<Fees_Collection_entity> students = service.getAllStudents();
		     
		     // Add student information to the model
		     model.addAttribute("student", students);
		     model.addAttribute("invoice", invoice);
		     
		     return "redirect:/invoice";
		 }



		 @GetMapping("/removeFee")
		 public String removeFee(@RequestParam int index) {
		     service.removeFee(index);
		     return "redirect:/invoice"; // Redirect to the invoice page or any other page
		 }
		 
		 
		 
		 
		 @GetMapping("/generatePDF")
		 public ResponseEntity<byte[]> generatePDF() {
		     try {
		         // Read HTML content from the file
		         ClassPathResource htmlResource = new ClassPathResource("templates/invoice.html");
		         String htmlContent = new String(htmlResource.getInputStream().readAllBytes());

		         // Generate PDF from HTML content
		         byte[] pdfBytes = pdfGenerationService.generatePdfFromHtml(htmlContent);

		         // Set content type and headers
		         HttpHeaders headers = new HttpHeaders();
		         headers.setContentType(MediaType.APPLICATION_PDF);
		         headers.setContentDispositionFormData("filename", "invoice.pdf");

		         return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
		     } catch (Exception e) {
		         e.printStackTrace();
		         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		     }
		 }

		 
		 
}



