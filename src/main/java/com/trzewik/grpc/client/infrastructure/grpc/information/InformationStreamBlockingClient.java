package com.trzewik.grpc.client.infrastructure.grpc.information;

import com.trzewik.activemq.infrastructure.grpc.information.InformationDTO;
import com.trzewik.activemq.interfaces.grpc.information.InformationForm;
import com.trzewik.activemq.interfaces.grpc.information.InformationStreamControllerGrpc;
import com.trzewik.grpc.client.domain.information.StreamInformationReceiver;
import io.grpc.StatusRuntimeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;

@Slf4j
@RequiredArgsConstructor
public class InformationStreamBlockingClient implements StreamInformationReceiver {
    private final InformationStreamControllerGrpc.InformationStreamControllerBlockingStub blockingStub;

    @Override
    public void streamInformation(String id) {
        log.info("Requesting information STREAM with id: [{}]", id);
        InformationForm form = InformationForm.newBuilder().setId(id).build();
        try {
            Iterator<InformationDTO> information = blockingStub.open(form);
            information.forEachRemaining(i -> log.info("Receive information [{}]", i));
        } catch (StatusRuntimeException ex) {
            log.warn("RPC failed: {}", ex.getStatus());
        }
    }
}
