package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.loading.PrivateClassLoader;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;
import com.example.demo.service.EmailService;
import com.sendgrid.Response;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class UsersController {
 @Autowired
 private EmailService emailService;
 @Autowired
 private UsersRepository usersRepository;

 
 //Get Users
 @GetMapping("Users")
 public List<Users> getAllUsers(){
	 return this.usersRepository.findAll();
 }
 
 //Get Users by id
 @GetMapping("/Users/{id}")
 public ResponseEntity<Users> getAllUsersById(@PathVariable(value="id") Long userId) 
		 throws ResourceNotFoundException {
	 Users users=usersRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: "+userId));
	 return ResponseEntity.ok().body(users);
 }
 
//Get Users by email
@GetMapping("/User/{email}")
public ResponseEntity<Users> getAllUsersByEmail(@PathVariable(value="email") String Email) 
		 throws ResourceNotFoundException {
	 Users users=usersRepository.findByEmail(Email).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: "+Email));
	 return ResponseEntity.ok().body(users);
}

 //Get otp by email
 @GetMapping("/otp/{email}")
 public ResponseEntity<String> getAllUsersByOtp(@PathVariable(value="email") String Email) 
		 throws ResourceNotFoundException {
	 Users users=usersRepository.findByEmail(Email).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: "+Email));
	 return ResponseEntity.ok().body(users.otp);
 }
//Get btn by email
@GetMapping("/btn/{email}")
public ResponseEntity<String> getAllUsersByBtn(@PathVariable(value="email") String Email) 
		 throws ResourceNotFoundException {
	 Users users=usersRepository.findByEmail(Email).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: "+Email));
	 return ResponseEntity.ok().body(users.btn);
}
 //save Users
 @PostMapping("Users")
 public Object createUsers(@RequestBody Users users) {
	  Users user=usersRepository.findByEmail(users.getEmail()).orElse(null);
	    if(user == null){
	    	Response response=emailService.sendemail(users);
	    	return this.usersRepository.save(users);
	    }
	    else return "A User with that email already exists";
	}

 @PostMapping("Users/send")
 public boolean postBody(@RequestBody Users users ) {
  Users OTP= usersRepository.findByOtp(users.getOtp()).orElse(null);
	 if((OTP!=null)&& (OTP.getEmail().equals(users.getEmail())))
	 {
		 return true;
	 }
	 else {
		return false;
	}
 }

 //Update Users
 @PutMapping("Users/{email}")
 public ResponseEntity<Users> updateUsers(@PathVariable(value = "email") String Email,
 @Valid @RequestBody Users UsersDetails) throws ResourceNotFoundException{
	 
	 Users users=usersRepository.findByEmail(Email).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: "+Email));
	 Response response=emailService.sendemail(users);
	 users.setUser(UsersDetails.getUser());
	 users.setEmail(UsersDetails.getEmail());
	 users.setBtn(UsersDetails.getBtn());
//	 users.setOtp(UsersDetails.getOtp());
	 return ResponseEntity.ok(this.usersRepository.save(users));
 }
 
 //delete Users
 @DeleteMapping("Users/{id}")
 public Map<String,Boolean> deleteUsers(@PathVariable(value="id") Long userId) throws ResourceNotFoundException{
	 Users users=usersRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: "+userId));

	 this.usersRepository.delete(users);
	 
	 Map<String,Boolean> response=new HashMap<>();
	 response.put("deleted",Boolean.TRUE);
	 
	 return response;

 }
 }

