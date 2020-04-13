package com.trzewik.grpc.client.domain.information;

public interface InformationService {
    void getInformation(String id);

    void startBlockingStream(String id);

    void startStream(String id);
}
