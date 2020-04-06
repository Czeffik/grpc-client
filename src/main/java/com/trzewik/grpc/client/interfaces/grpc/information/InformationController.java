package com.trzewik.grpc.client.interfaces.grpc.information;

import com.trzewik.grpc.client.domain.information.InformationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;

@Slf4j
@RequiredArgsConstructor
@GRpcService
public class InformationController {
    private final InformationService informationService;

}
