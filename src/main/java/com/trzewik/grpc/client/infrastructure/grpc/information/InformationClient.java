package com.trzewik.grpc.client.infrastructure.grpc.information;

import com.trzewik.activemq.infrastructure.grpc.information.InformationDTO;
import com.trzewik.activemq.interfaces.grpc.information.InformationControllerGrpc;
import com.trzewik.activemq.interfaces.grpc.information.InformationForm;
import com.trzewik.grpc.client.domain.information.InformationReceiver;
import io.grpc.StatusRuntimeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class InformationClient implements InformationReceiver {
    private final InformationControllerGrpc.InformationControllerBlockingStub blockingStub;

    @Override
    public void getInformation(String id) {
        log.info("Requesting information with id: [{}]", id);
        InformationForm form = InformationForm.newBuilder().setId(id).build();
        try {
            InformationDTO information = blockingStub.getInformation(form);
            log.info("Received information: {}", information);
        } catch (StatusRuntimeException ex) {
            log.warn("RPC failed: {}", ex.getStatus());
        }
    }
}
