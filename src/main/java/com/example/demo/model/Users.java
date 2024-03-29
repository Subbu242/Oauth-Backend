package com.example.demo.model;
import javax.persistence.*;

import javax.persistence.Id;
//import com.twilio.type.PhoneNumber;

@Entity
@Table(name="Users")
public class Users {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		public Long id;
	   
		@Column(unique=true ,name="email")
	    private String email;
	    @Column(name="username")
	    private String user;	    
	    @Column(name="MFA_Enabled_Btn")
		public String btn;
	    @Column(name="otp")
	    public String otp;
//	    @Column(name="phone")
//	    public String phone;
	    
//	    public String getPhone() {
//			return phone;
//		}
//
//		public void setPhone(String phone) {
//			this.phone = phone;
//		}		
	    
	    public String getOtp() {
			return otp;
		}

		public void setOtp(String otp) {
			this.otp = otp;
		}

		public String getBtn() {
			return btn;
		}

		public void setBtn(String btn) {
			this.btn = btn;
		}

		public Users() {
			super();
		}

		public Users(String email, String user, String btn, String otp, String phone) {
			super();
			this.email = email;
			this.user = user;
			this.btn = btn;
			this.otp = otp;
//			this.phone = phone;
		}

		public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getUser() {
	        return user;
	    }

	    public void setUser(String user) {
	        this.user = user;
	    }
	    
	    public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

	}
