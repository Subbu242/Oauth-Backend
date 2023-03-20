package com.example.demo.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Users;
//import com.twilio.type.PhoneNumber;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

	Optional<Users> findByEmail(String email);

	Optional<Users> findByOtp(String otp);

//	Optional<Users> findByPhone(String phone);

	
}
