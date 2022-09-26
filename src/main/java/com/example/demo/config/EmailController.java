//package com.example.demo.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.model.EmailRequest;
//import com.example.demo.model.Users;
//import com.example.demo.service.EmailService;
//import com.sendgrid.Response;
//@RestController
//@RequestMapping("/api/v1/")
//public class EmailController {
//
////	@Autowired
////	EmailService emailService;
////	@GetMapping("/sendMail/{email}")
////	public String sendEmail(@PathVariable(value="email",required=true) String Email)
////	{
////		return emailService.sendEmail(Email);
////	}
//	@Autowired
//	private EmailService emailService;
//	
//	@PostMapping("Users/sendemail")
//	public ResponseEntity<String> sendemail(@RequestBody Users users)
//	{
//		Response response=emailService.sendemail(users);
//		if(response.getStatusCode()==200||response.getStatusCode()==202)
//			return new ResponseEntity<>("send success", HttpStatus.OK);
//		return new ResponseEntity<>("Failed to send", HttpStatus.NOT_FOUND);
//	}
//	
//}
