package com.trzewik.grpc.client.domain.information;

class InformationServiceImpl implements InformationService {
    @Override
    public Information getInformation(String id) {
        return new Information(id, "Fake message");
    }
}
