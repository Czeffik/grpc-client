package com.trzewik.grpc.client.interfaces.rest;

import com.trzewik.grpc.client.domain.information.InformationService;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
public class RestInterfacesConfiguration {
    @Bean
    public InformationController informationController(InformationService informationService) {
        return new InformationController(informationService);
    }

    @Bean
    DispatcherServletPath dispatcherServletPath(DispatcherServlet dispatcherServlet) {
        return new DispatcherServletRegistrationBean(dispatcherServlet, "/");
    }

    @Bean
    DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }
}
