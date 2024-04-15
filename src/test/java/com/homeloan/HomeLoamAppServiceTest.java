package com.homeloan;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.TestPropertySource;

import com.homeloan.beans.User;
import com.homeloan.controller.RegistrationController;
import com.homeloan.dto.CustomerLoginDto;
import com.homeloan.dto.CustomerRegisteration;
import com.homeloan.service.DefaultUserServiceImpl;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-test.properties")
class HomeLoamAppServiceTest {
	
	@Autowired
	private DefaultUserServiceImpl dservice;
	
	@Autowired
	private RegistrationController rc;
	

	@Test
	void RegisterService() {
		 CustomerLoginDto c=new CustomerLoginDto();
		  c.setUserName("raju");
		  c.setUserMobile("87654321");
		  c.setUserEmail("balaraju434@gmail.com");
		  c.setUserAddress("Chinnapuram");
		  c.setState("AP");
		  c.setPost("Chinnapram");
		  c.setCountry("India");
		  c.setPassword("balaraju");
		  c.setArea("Gollapalem");
		  
		 
		  
		  User user = dservice.save(c);
		  assertNotNull(user);
	}
	
	@Test
	void loginService() {
		 
		 
		  
		 UserDetails loadUserByUsername = dservice.loadUserByUsername("bala@434");
		  assertNotNull(loadUserByUsername);
		 // UserDetails loadUserByUsername1 = dservice.loadUserByUsername("bal");
		 
	}
	
	@Test
	void userRegistrationDtoTest() {
		 
		 CustomerRegisteration cr = rc.userRegistrationDto();
		 cr.setName("ravi");
		 cr.setMobile("8765434562");
		 cr.setPassword("ravi");
		 cr.setEmailId("ravi@gmaill.com");
		 assertNotNull(cr);
	}
	
   


}
