package com.homeloan.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.homeloan.beans.LoanEntity;

class LoanEntityTest {

	@Test
    public void testGetterAndSetterMethods() {
        LoanEntity loanEntity = new LoanEntity();
        loanEntity.setId(1);
        loanEntity.setUserId(1);
        loanEntity.setFirstName("John");
        loanEntity.setLastName("Doe");
        loanEntity.setMobile("1234567890");
        loanEntity.setEmail("john.doe@example.com");
        loanEntity.setAddress("123 Main St, Anytown");
        loanEntity.setAdharCard("1234 5678 9012");
        loanEntity.setPancard("ABCDE1234F");
        loanEntity.setAmount("100000");
        loanEntity.setTenure("5 years");
        loanEntity.setInterest("10%");
        loanEntity.setEmi("2000");
        loanEntity.setStatus("Approved");
        loanEntity.setTypeOfLoan("Home Loan");
        loanEntity.setInititedDate(new Date());
        loanEntity.setDocApproval("Yes");
        loanEntity.setRmApproval("Yes");

        assertEquals(1, loanEntity.getId());
        assertEquals(1, loanEntity.getUserId());
        assertEquals("John", loanEntity.getFirstName());
        assertEquals("Doe", loanEntity.getLastName());
        assertEquals("1234567890", loanEntity.getMobile());
        assertEquals("john.doe@example.com", loanEntity.getEmail());
        assertEquals("123 Main St, Anytown", loanEntity.getAddress());
        assertEquals("1234 5678 9012", loanEntity.getAdharCard());
        assertEquals("ABCDE1234F", loanEntity.getPancard());
        assertEquals("100000", loanEntity.getAmount());
        assertEquals("5 years", loanEntity.getTenure());
        assertEquals("10%", loanEntity.getInterest());
        assertEquals("2000", loanEntity.getEmi());
        assertEquals("Approved", loanEntity.getStatus());
        assertEquals("Home Loan", loanEntity.getTypeOfLoan());
        assertEquals("Yes", loanEntity.getDocApproval());
        assertEquals("Yes", loanEntity.getRmApproval());
    }

    @Test
    public void testToStringMethod() {
        LoanEntity loanEntity = new LoanEntity();
        loanEntity.setId(1);
        loanEntity.setUserId(1);
        loanEntity.setFirstName("John");
        loanEntity.setLastName("Doe");
        loanEntity.setMobile("1234567890");
        loanEntity.setEmail("john.doe@example.com");
        loanEntity.setAddress("123 Main St, Anytown");
        loanEntity.setAdharCard("1234 5678 9012");
        loanEntity.setPancard("ABCDE1234F");
        loanEntity.setAmount("100000");
        loanEntity.setTenure("5 years");
        loanEntity.setInterest("10%");
        loanEntity.setEmi("2000");
        loanEntity.setStatus("Approved");
        loanEntity.setTypeOfLoan("Home Loan");
        loanEntity.setInititedDate(new Date());
        loanEntity.setDocApproval("Yes");
        loanEntity.setRmApproval("Yes");

        String expectedToString = "LoanEntity(id=1, userId=1, firstName=John, lastName=Doe, mobile=1234567890, email=john.doe@example.com, address=123 Main St, Anytown, adharCard=1234 5678 9012, pancard=ABCDE1234F, amount=100000, tenure=5 years, interest=10%, emi=2000, status=Approved, typeOfLoan=Home Loan, inititedDate=" + loanEntity.getInititedDate() + ", docApproval=Yes, rmApproval=Yes)";
        assertEquals(expectedToString, loanEntity.toString());
    }

}
