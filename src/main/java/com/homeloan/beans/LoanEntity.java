package com.homeloan.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoanEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int userId;
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
	@CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
	private Date inititedDate;
	private String docApproval="0";
	private String rmApproval="0";
}
