package com.homeloan.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.homeloan.dto.CustomerRegisteration;

class CustomerRegisterationTest {

	@Test
    public void testGetterAndSetterMethods() {
        CustomerRegisteration customer = new CustomerRegisteration();
        customer.setName("John Doe");
        customer.setEmailId("john.doe@example.com");
        customer.setMobile("1234567890");
        customer.setPassword("password");

        assertEquals("John Doe", customer.getName());
        assertEquals("john.doe@example.com", customer.getEmailId());
        assertEquals("1234567890", customer.getMobile());
        assertEquals("password", customer.getPassword());
        assertEquals("USER", customer.getRole());
    }

    @Test
    public void testToStringMethod() {
        CustomerRegisteration customer = new CustomerRegisteration();
        customer.setName("John Doe");
        customer.setEmailId("john.doe@example.com");
        customer.setMobile("1234567890");
        customer.setPassword("password");

        String expectedToString = "CustomerRegisteration(name=John Doe, emailId=john.doe@example.com, mobile=1234567890, password=password, role=USER)";
        assertEquals(expectedToString, customer.toString());
    }

}
