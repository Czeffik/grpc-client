package com.trzewik.grpc.client.domain.information;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
class InformationServiceImpl implements InformationService {
    private final InformationReceiver receiver;
    private final StreamInformationReceiver stream;

    @Override
    public void getInformation(String id) {
        receiver.getInformation(id);
    }

    @Override
    public void startStream(String id) {
        stream.streamInformation(id);
    }
}
