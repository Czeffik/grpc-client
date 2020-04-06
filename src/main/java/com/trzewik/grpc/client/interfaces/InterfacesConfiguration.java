package com.trzewik.grpc.client.interfaces;

import com.trzewik.grpc.client.interfaces.grpc.GrpcInterfacesConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({
    GrpcInterfacesConfiguration.class
})
@Configuration
public class InterfacesConfiguration {
}
