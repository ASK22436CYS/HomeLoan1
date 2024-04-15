package com.homeloan.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.homeloan.beans.Roles;

class RolesTest {

	@Test
    public void testGetterAndSetterMethods() {
        Roles roles = new Roles();
        roles.setId(1);
        roles.setRole("ROLE_USER");

        assertEquals(1, roles.getId());
        assertEquals("ROLE_USER", roles.getRole());
    }

    @Test
    public void testToStringMethod() {
        Roles roles = new Roles();
        roles.setId(1);
        roles.setRole("ROLE_USER");

        String expectedToString = "Roles [id=1, role=ROLE_USER]";
        assertEquals(expectedToString, roles.toString());
    }

}
