package com.example.demo.service;

import java.io.IOException;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.model.EmailRequest;
import com.example.demo.model.Users;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;


@Service
public class EmailService {
	public String otp;
	@Autowired
	SendGrid sendGrid;	
	public Response sendemail(Users users) {
		Random random=new Random();		
		StringBuilder sb=new StringBuilder();		
		for(int i=0 ; i< 6 ; i++)
		{
			sb.append(random.nextInt(10));
		} otp=sb.toString();
		  users.setOtp(otp);
		String subject="User Verification";
		 Mail mail = new Mail(new Email("rdhun001@odu.edu"), subject, new Email(users.getEmail()),new Content("text/plain",otp));
		 mail.setReplyTo(new Email("subhusubhash24@gmail.com"));
		    Request request = new Request();
		    Response response=null;
		    try {
		      request.setMethod(Method.POST);
		      request.setEndpoint("mail/send");
		      request.setBody(mail.build());
		      response = sendGrid.api(request);
		    } catch (IOException ex) {
		      System.out.println(ex.getMessage());
		    }
		    return response;
	}
}
	

