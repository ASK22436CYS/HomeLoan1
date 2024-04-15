package com.homeloan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.ui.Model;

import com.homeloan.beans.User;
import com.homeloan.controller.DashboardController;
import com.homeloan.controller.LoginController;
import com.homeloan.controller.RegistrationController;
import com.homeloan.dao.CustomerRepository;
import com.homeloan.dto.CustomerLoginDto;
import com.homeloan.dto.LoginDto;
import com.homeloan.service.DefaultUserService;
import com.homeloan.service.LoanService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-test.properties")
class HomeLoanApplicationTests {
	
	@InjectMocks
	private RegistrationController rgController;
	@InjectMocks
	private LoginController logCon;
	@InjectMocks
	private DashboardController dashboardController;
	@Mock
	private DefaultUserService dservice;

	@Mock
	private CustomerRepository crespo;
	
	
	@Mock
	private Model mo;
	
	 @Mock
	    private HttpServletRequest request;
	
	
	@Mock
    private CustomerRepository userRepository;

    @Mock
    private LoanService loanService;

    


	@Test
	void registerPage() {
		String showRegistrationForm = rgController.showRegistrationForm(mo);
		assertEquals("register", showRegistrationForm);
	}
	
	
	  @Test 
	  void save() { 
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
		  
		  User u=new User();
		  u.setUserName(c.getUserName());
		  u.setArea(c.getArea());
		  u.setCountry(c.getCountry());
		  u.setPassword(c.getPassword());
		  u.setPost(c.getPost());
		  u.setState(c.getState());
		  u.setUserAddress(c.getUserAddress());
		  u.setUserEmail(c.getUserEmail());
		  u.setUserMobile(u.getUserMobile());
		  Mockito.when(crespo.save(u)).thenReturn(u);
		  Mockito.when(dservice.save(c)).thenReturn(u);
		  String registerUserAccount = rgController.registerUserAccount(c);
		  assertEquals("redirect:/login", registerUserAccount);
	   }
	  @Test
	  public void loginUser() {
		  LoginDto l=new LoginDto();
		  l.setUsername("bala@434");
		  l.setPassword("raju434");
		 // UserDetails u = dservice.loadUserByUsername(l.getUsername());
		  //Mockito.when(dservice.loadUserByUsername(l.getUsername()).thenReturn(org.springframework.security.core.userdetails.User));
		  logCon.loginUser(l);
		 // assertEquals("bala@434", u.getUsername());
		  
	  }
	  @Test
	  public void loginPage() {
		  String login = logCon.login();
		 assertEquals("login", login);
	  }
	  
	  @Test
	  public void loginPageDTO() {
		 LoginDto userLoginDTO = logCon.userLoginDTO();
		 assertNotNull(userLoginDTO);
		 String loanSearch = dashboardController.getLoanSearch();
		 assertEquals("loansearch", loanSearch);
		 String loanOfferings = dashboardController.loanOfferings();
		 assertEquals("LoanOfferings", loanOfferings);
		 String applyLoan = dashboardController.getApplyLoan();
		 assertEquals("applyLoan", applyLoan);
		 String loan = dashboardController.applyLoan();
		 assertEquals("", loan);
		 
		 request.setAttribute("address", "HYD");
		 request.setAttribute("adharCard", "1234567890");
		 request.setAttribute("amount", "2345678");
		 request.setAttribute("email", "raju@gmail.com");
		 request.setAttribute("emi", "2345");
		 request.setAttribute("firstName", "raju");
		 request.setAttribute("interest", "4");
		 request.setAttribute("lastName", "k");
		 request.setAttribute("mobile", "845361246");
		 request.setAttribute("pancard", "GNDPK5678F");
		 request.setAttribute("tenure", "5");
		
		 
	  }
	  
	 

}
