package com.homeloan.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.homeloan.beans.User;
import com.homeloan.controller.AdminController;
import com.homeloan.dao.CustomerRepository;

@ExtendWith(MockitoExtension.class)
class AdminControllerTest {

	@Mock
    private CustomerRepository userRepository;

    @InjectMocks
    private AdminController adminController;

    @Test
    public void testDisplayDashboard() {
        SecurityContext securityContext = mock(SecurityContext.class);
        SecurityContextHolder.setContext(securityContext);

        Authentication authentication = mock(Authentication.class);
        UserDetails userDetails = mock(UserDetails.class);
        when(authentication.getPrincipal()).thenReturn(userDetails);

        when(securityContext.getAuthentication()).thenReturn(authentication);
        when(userDetails.getUsername()).thenReturn("test@test.com");

        User user = new User();
        user.setUserName("Test User");
        when(userRepository.findByUserEmail("test@test.com")).thenReturn(user);

        ModelMap model = new ModelMap();
        String viewName = adminController.displayDashboard(model);

        assertEquals("adminScreen", viewName);
        assertEquals("Test User", model.getAttribute("userDetails"));
    }

}
