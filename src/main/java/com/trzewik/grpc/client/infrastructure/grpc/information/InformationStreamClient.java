package com.trzewik.grpc.client.infrastructure.grpc.information;

import com.trzewik.activemq.infrastructure.grpc.information.InformationDTO;
import com.trzewik.activemq.interfaces.grpc.information.InformationForm;
import com.trzewik.activemq.interfaces.grpc.information.InformationStreamControllerGrpc;
import com.trzewik.grpc.client.domain.information.StreamInformationReceiver;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class InformationStreamClient implements StreamInformationReceiver {
    private final InformationStreamControllerGrpc.InformationStreamControllerStub stub;

    @Override
    public void streamInformation(String id) {
        log.info("Requesting information STREAM with non blocking stub with id: [{}]", id);
        final InformationForm form = InformationForm.newBuilder().setId(id).build();
        final InformationObserver observer = new InformationObserver();
        try {
            stub.open(form, observer);
        } catch (StatusRuntimeException ex) {
            log.warn("RPC failed: {}", ex.getStatus());
        }
    }

    @Slf4j
    public static class InformationObserver implements StreamObserver<InformationDTO> {
        @Override
        public void onNext(InformationDTO value) {
            log.info("Received information [{}]", value);
        }

        @Override
        public void onError(Throwable t) {
            log.error(String.valueOf(t));
        }

        @Override
        public void onCompleted() {
            log.info("Completed information observer - stream closed");
        }
    }
}
