package com.homeloan.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.homeloan.beans.LoanEntity;
import com.homeloan.beans.User;
import com.homeloan.dao.CustomerRepository;
import com.homeloan.dto.LoanDto;
import com.homeloan.service.LoanService;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

	@Autowired
	private CustomerRepository userRepository;
	@Autowired
	private LoanService loanService;

	
	
	@GetMapping
	public String displayDashboard(ModelMap model) throws ParseException {
//		String user= returnUsername();
//        model.addAttribute("userDetails", user);
		User returnUsers = returnUsers();
//		LoanEntity getbyUserId = lo
//		if (getbyUserId != null) {
//			DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("mm/dd/yyyy");
//			Date inititedDate = getbyUserId.getInititedDate();
////			System.out.println(inititedDate.getYear());
////			LocalDate of = LocalDate.of(inititedDate.getYear(), inititedDate.getMonth(), inititedDate.getDate());
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			Date dateWithoutTime = sdf.parse(sdf.format(inititedDate));
//			model.addAttribute("initiatedDate", dateWithoutTime);
//			model.addAttribute("loanentity", getbyUserId);
//			model.addAttribute("Docapproval", getbyUserId.getDocApproval().equals("1") ? "APPROVED" : "PEDING");
//			model.addAttribute("RMapproval", getbyUserId.getRmApproval().equals("1") ? "APPROVED" : "PEDING");
//		}
		List<LoanEntity> getbyUserId = loanService.getbyUserId(returnUsers.getId());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.mm.yyyy");
		
		getbyUserId.stream().map(t->{LoanEntity loanEntity = t;
//	LocalDate date = LocalDate.parse(simpleDateFormat.format(t.getInititedDate()));
	java.util.Date d;
	try {
//		d = new SimpleDateFormat("yyyy-MM-dd").parse(t.getInititedDate().toString());
//		 DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
//		 SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
//	        Date date = dt.parse(d.toString());
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		  String formattedDate = dateFormat.format(t.getInititedDate());
		Date parsedDate = dateFormat.parse(t.getInititedDate().toString());
		loanEntity.setInititedDate(parsedDate);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		return loanEntity;}).collect(Collectors.toList());
		model.addAttribute("loanrecord", getbyUserId);
		System.out.println(getbyUserId);
		return "dashboard";
	}

	public User returnUsers() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		UserDetails user = (UserDetails) securityContext.getAuthentication().getPrincipal();
		User users = userRepository.findByUserEmail(user.getUsername());
		return users;
	}

	@PostMapping("/newLoan")
	public String getLoanForm(HttpServletRequest request,Model model) {
	LoanDto loanDto = new	LoanDto(); 
	loanDto.setEmi(request.getParameter("emi"));
	loanDto.setInterestAmount(request.getParameter("interestAmount"));
	loanDto.setPrincipal(request.getParameter("loanamount"));
	loanDto.setRateofInterest(request.getParameter("rateofinterest"));
	System.out.println("tenure"+request.getParameter("tenure"));
	loanDto.setTenure(request.getParameter("tenure"));
	loanDto.setTotalAmount(request.getParameter("totalAmount"));
	loanDto.setTypeOfLoan(request.getParameter("typeofloan"));
	model.addAttribute("loanDto", loanDto);
	System.out.println(loanDto);
		return "newLoan";
	}

	@PostMapping("/saveLoan")
	public String saveLoan(HttpServletRequest request) {
		LoanEntity loanEntity = new LoanEntity();
		loanEntity.setAddress(request.getParameter("address"));
		loanEntity.setAdharCard(request.getParameter("adharCard"));
		loanEntity.setAmount(request.getParameter("amount"));
		loanEntity.setEmail(request.getParameter("email"));
		loanEntity.setEmi(request.getParameter("emi"));
		loanEntity.setFirstName(request.getParameter("firstName"));
		loanEntity.setInterest(request.getParameter("interest"));
		loanEntity.setLastName(request.getParameter("lastName"));
		loanEntity.setMobile(request.getParameter("mobile"));
		loanEntity.setPancard(request.getParameter("pancard"));
		loanEntity.setTenure(request.getParameter("tenure"));
		System.out.println(loanEntity);
		SecurityContext securityContext = SecurityContextHolder.getContext();
		UserDetails user = (UserDetails) securityContext.getAuthentication().getPrincipal();
		User users = userRepository.findByUserEmail(user.getUsername());
		loanEntity.setUserId(users.getId());
		LoanEntity saveEntity = loanService.saveEntity(loanEntity);

		return "redirect:/dashboard";
	}
	@GetMapping("/loanOfferings")
	public String loanOfferings() {
		return "LoanOfferings";
	}
	
	@GetMapping("/applyLoan")
	public String getApplyLoan() {
		return "applyLoan";
	}
	
	@PostMapping("/loanApply")
	public String applyLoan() {
		return"";
	}
	@GetMapping("/loanSearch")
	public String getLoanSearch() {
		
//		System.out.println("loanentity"+loanentity);
		return "loansearch";
	}
	
	@GetMapping("/getLoanEntity/{id}")
	@ResponseBody
	public LoanEntity getLoanData(@PathVariable("id") int id) {
		System.out.println("id::"+id);
		User returnUsers = returnUsers();
		LoanEntity loanentity = loanService.getLoanentity(returnUsers.getId(),id);
		LocalDate now = LocalDate.now();
		int year =Integer.valueOf(String.valueOf("20"+loanentity.getInititedDate().getYear()%100));
		LocalDate of = LocalDate.of(year, loanentity.getInititedDate().getMonth()+1, loanentity.getInititedDate().getDate());
		Date date = new Date();
		 long differenceInDays = Math.abs(ChronoUnit.DAYS.between(now, of));
		 System.out.println(differenceInDays);
		System.out.println("loanentity:"+loanentity);
		if(differenceInDays>14) {
		loanentity.setStatus("success");	
		return loanentity;
		}else {
			loanentity.setStatus("fail");
			return loanentity;
		}
	}
}


