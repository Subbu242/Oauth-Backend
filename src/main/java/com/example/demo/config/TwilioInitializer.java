//package com.example.demo.config;
//
//
//
//	import org.springframework.context.annotation.Configuration;
//
//	import com.twilio.Twilio;
//
//	@Configuration
//	public class TwilioInitializer {
//		
//		private final TwilioConfig twilioproperties;
//		
//		public TwilioInitializer(TwilioConfig twilioproperties)
//		{
//			this.twilioproperties=twilioproperties;
//			Twilio.init(twilioproperties.getAccountSid(), twilioproperties.getAuthToken());
//			System.out.println("twilio intialized with account: "+twilioproperties.getAccountSid());
//		}
//
//	}