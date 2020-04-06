package com.trzewik.grpc.client.infrastructure;

import com.trzewik.grpc.client.domain.information.InformationService;
import com.trzewik.grpc.client.domain.information.InformationServiceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfiguration {
    @Bean
    InformationService informationService() {
        return InformationServiceFactory.create();
    }
}
