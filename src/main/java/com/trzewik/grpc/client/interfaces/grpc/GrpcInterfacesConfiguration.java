package com.trzewik.grpc.client.interfaces.grpc;

import com.trzewik.grpc.client.domain.information.InformationService;
import com.trzewik.grpc.client.interfaces.grpc.information.InformationController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcInterfacesConfiguration {

    @Bean
    InformationController informationController(InformationService informationService) {
        return new InformationController(informationService);
    }
}
