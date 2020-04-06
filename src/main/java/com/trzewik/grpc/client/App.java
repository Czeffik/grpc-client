package com.trzewik.grpc.client;

import com.trzewik.grpc.client.infrastructure.DomainConfiguration;
import com.trzewik.grpc.client.infrastructure.InfrastructureConfiguration;
import com.trzewik.grpc.client.interfaces.InterfacesConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;

@Import(
    {
        DomainConfiguration.class,
        InfrastructureConfiguration.class,
        InterfacesConfiguration.class
    }
)
@SpringBootConfiguration
@EnableAutoConfiguration
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
