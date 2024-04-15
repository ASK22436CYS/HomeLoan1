package com.homeloan;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.builder.SpringApplicationBuilder;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ServletInitializerTest {

	@Mock
    private SpringApplicationBuilder springApplicationBuilder;

    @Test
    public void testConfigure() {
        ServletInitializer servletInitializer = new ServletInitializer();
        servletInitializer.configure(springApplicationBuilder);
        verify(springApplicationBuilder).sources(HomeLoanApplication.class);
    }

}
