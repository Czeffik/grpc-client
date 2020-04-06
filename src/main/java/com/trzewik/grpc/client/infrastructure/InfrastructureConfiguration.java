package com.trzewik.grpc.client.infrastructure;

import com.trzewik.grpc.client.infrastructure.grpc.GrpcInfrastructureConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({
    GrpcInfrastructureConfiguration.class
})
@Configuration
public class InfrastructureConfiguration {
}
