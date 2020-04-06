package com.trzewik.grpc.client.interfaces;

import com.trzewik.grpc.client.interfaces.rest.RestInterfacesConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({
    RestInterfacesConfiguration.class
})
@Configuration
public class InterfacesConfiguration {
}
