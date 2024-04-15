package com.homeloan.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.homeloan.beans.LoanBean;

class LoanBeanTest {

	@Test
    public void testToString() {
        LoanBean loanBean = new LoanBean();
        loanBean.setFirstName("John");
        loanBean.setLastName("Doe");
        loanBean.setMobile("1234567890");
        loanBean.setEmail("john.doe@example.com");
        loanBean.setAddress("123 Main St, Anytown");
        loanBean.setAdharCard("1234 5678 9012");
        loanBean.setPancard("ABCDE1234F");
        loanBean.setAmount("100000");
        loanBean.setTenure("5 years");
        loanBean.setInterest("10%");
        loanBean.setEmi("2000");
        loanBean.setTypeOfLoan("Home Loan");
        loanBean.setInititedDate(new Date());
        loanBean.setDocApproval("Yes");
        loanBean.setRmApproval("Yes");

        String expectedToString = "LoanBean(firstName=John, lastName=Doe, mobile=1234567890, email=john.doe@example.com, address=123 Main St, Anytown, adharCard=1234 5678 9012, pancard=ABCDE1234F, amount=100000, tenure=5 years, interest=10%, emi=2000, typeOfLoan=Home Loan, inititedDate=" + loanBean.getInititedDate() + ", docApproval=Yes, rmApproval=Yes)";
        assertEquals(expectedToString, loanBean.toString());
    }

}
