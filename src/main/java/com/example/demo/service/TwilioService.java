//package com.example.demo.service;
//
//import java.util.Random;
//
////public class TwilioService {
////	 
////    // Find your Account Sid and Token at twilio.com/console 
////    public static final String ACCOUNT_SID = "AC269654527904be3092ffc675a3d7d07d"; 
////    public static final String AUTH_TOKEN = "4ed4ea335946c03f296f12dceeeb2e4e"; 
////
////    	public String otp;	
////    	public String sendsms(Users users) {
////    		Random random=new Random();	
////    		String to=users.getPhone();
////    		StringBuilder sb=new StringBuilder();		
////    		for(int i=0 ; i< 6 ; i++)
////    		{
////    			sb.append(random.nextInt(10));
////    		} otp=sb.toString();
////    		  users.setOtp(otp);
////        Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
////        Message message = Message.creator(new com.twilio.type.PhoneNumber(to),"MGfc50c7852a8e1a778b001c685dc36d48","Your OTP is: "+otp).create(); 
////        System.out.println(message.getSid()); 
////        return otp;
////    } 
////}
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.config.TwilioConfig;
//import com.example.demo.model.Users;
//import com.twilio.rest.api.v2010.account.Message;
//import com.twilio.type.PhoneNumber;
//
//@Service
//public class TwilioService {
//
//	private final TwilioConfig twilioproperties;
//	
//	@Autowired
//	public TwilioService(TwilioConfig twilioproperties)
//	{
//		this.twilioproperties=twilioproperties;
//	}
//	
//	//send message to number	   
//		public String otp;	
//    	public String sendsms(Users users) {
//    		Random random=new Random();	
//    		String to="+91"+users.getPhone();
//    		StringBuilder sb=new StringBuilder();		
//    		for(int i=0 ; i< 6 ; i++)
//    		{
//    			sb.append(random.nextInt(10));
//    		} otp=sb.toString();
//    		  users.setOtp(otp); 
//        Message message = Message.creator(new com.twilio.type.PhoneNumber(to),"MGfc50c7852a8e1a778b001c685dc36d48","Your OTP is: "+otp).create(); 
//        System.out.println(message.getSid()); 
//        return message.getStatus().toString();        
//	
//	}
//}