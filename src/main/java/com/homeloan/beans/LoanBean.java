package com.homeloan.beans;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class LoanBean {

	private String firstName;
	private String lastName;
	private String mobile;
	private String email;
	private String address;
	private String adharCard;
	private String pancard;
	
	
	private String amount;
	private String tenure;
	private String interest;
	private String emi;

	
	private String typeOfLoan;
	
	private Date inititedDate;
	private String docApproval;
	private String rmApproval;
	
}