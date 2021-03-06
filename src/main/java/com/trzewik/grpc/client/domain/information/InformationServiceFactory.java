package com.trzewik.grpc.client.domain.information;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InformationServiceFactory {

    public static InformationService create(
        InformationReceiver informationReceiver,
        StreamInformationReceiver streamInformationBlockingReceiver,
        StreamInformationReceiver streamInformationReceiver
    ) {
        return new InformationServiceImpl(informationReceiver, streamInformationBlockingReceiver, streamInformationReceiver);
    }
}
