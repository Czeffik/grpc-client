package com.trzewik.grpc.client.infrastructure.grpc;

import com.trzewik.activemq.interfaces.grpc.information.InformationControllerGrpc;
import com.trzewik.activemq.interfaces.grpc.information.InformationStreamControllerGrpc;
import com.trzewik.grpc.client.domain.information.InformationReceiver;
import com.trzewik.grpc.client.domain.information.StreamInformationReceiver;
import com.trzewik.grpc.client.infrastructure.grpc.information.InformationClient;
import com.trzewik.grpc.client.infrastructure.grpc.information.InformationStreamBlockingClient;
import com.trzewik.grpc.client.infrastructure.grpc.information.InformationStreamClient;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcInfrastructureConfiguration {

    @Bean
    InformationReceiver informationClient(Channel channel) {
        return new InformationClient(InformationControllerGrpc.newBlockingStub(channel));
    }

    @Bean
    StreamInformationReceiver informationStreamBlockingClient(Channel channel) {
        return new InformationStreamBlockingClient(InformationStreamControllerGrpc.newBlockingStub(channel));
    }

    @Bean
    StreamInformationReceiver informationStreamBClient(Channel channel) {
        return new InformationStreamClient(InformationStreamControllerGrpc.newStub(channel));
    }

    @Bean
    ManagedChannel managedChannel(@Value("${grpc.address}") String address) {
        return ManagedChannelBuilder
            .forTarget(address)
            .usePlaintext()
            .build();
    }
}
