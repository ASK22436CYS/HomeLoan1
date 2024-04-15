package com.homeloan.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.homeloan.dto.LoanDto;

class LoanDtoTest {

	@Test
    public void testGetterAndSetterMethods() {
        LoanDto loanDto = new LoanDto();
        loanDto.setIntrestAmount("10000");
        loanDto.setTypeOfLoan("Home Loan");
        loanDto.setPrincipal("500000");
        loanDto.setRateofInterest("8%");
        loanDto.setTenure("5 years");
        loanDto.setEmi("10000");
        loanDto.setInterestAmount("50000");
        loanDto.setTotalAmount("550000");

        assertEquals("10000", loanDto.getIntrestAmount());
        assertEquals("Home Loan", loanDto.getTypeOfLoan());
        assertEquals("500000", loanDto.getPrincipal());
        assertEquals("8%", loanDto.getRateofInterest());
        assertEquals("5 years", loanDto.getTenure());
        assertEquals("10000", loanDto.getEmi());
        assertEquals("50000", loanDto.getInterestAmount());
        assertEquals("550000", loanDto.getTotalAmount());
    }

    @Test
    public void testToStringMethod() {
        LoanDto loanDto = new LoanDto();
        loanDto.setIntrestAmount("10000");
        loanDto.setTypeOfLoan("Home Loan");
        loanDto.setPrincipal("500000");
        loanDto.setRateofInterest("8%");
        loanDto.setTenure("5 years");
        loanDto.setEmi("10000");
        loanDto.setInterestAmount("50000");
        loanDto.setTotalAmount("550000");

        String expectedToString = "LoanDto(intrestAmount=10000, typeOfLoan=Home Loan, principal=500000, rateofInterest=8%, tenure=5 years, emi=10000, interestAmount=50000, totalAmount=550000)";
        assertEquals(expectedToString, loanDto.toString());
    }

}
