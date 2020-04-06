package com.trzewik.grpc.client.domain.information;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Information {
    private final String id;
    private final String message;
}
