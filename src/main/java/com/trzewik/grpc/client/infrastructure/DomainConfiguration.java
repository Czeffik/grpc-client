package com.trzewik.grpc.client.infrastructure;

import com.trzewik.grpc.client.domain.information.InformationReceiver;
import com.trzewik.grpc.client.domain.information.InformationService;
import com.trzewik.grpc.client.domain.information.InformationServiceFactory;
import com.trzewik.grpc.client.domain.information.StreamInformationReceiver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfiguration {
    @Bean
    InformationService informationService(InformationReceiver informationReceiver, StreamInformationReceiver streamInformationReceiver) {
        return InformationServiceFactory.create(informationReceiver, streamInformationReceiver);
    }
}
