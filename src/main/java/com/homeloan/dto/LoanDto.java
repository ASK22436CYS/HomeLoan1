package com.homeloan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class LoanDto {
	
	private String intrestAmount;
	private String typeOfLoan;
	private String principal;
	private String rateofInterest;
	private String tenure;
	private String emi;
	private String interestAmount;
	private String totalAmount;
}
