package br.com.eletrica.common.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.spring.web.plugins.Docket;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@EnableWebMvc
public class SwaggerConfigTest {

    private SwaggerConfig swaggerConfig;

    @BeforeEach
    public void setUp() {
        swaggerConfig = new SwaggerConfig();
    }

    @Test
    public void testApiBean() {
        WebApplicationContext context = mock(WebApplicationContext.class);
        when(context.getServletContext()).thenReturn(mock(javax.servlet.ServletContext.class));
        Docket docket = swaggerConfig.api();
        assertNotNull(docket);
    }
}
