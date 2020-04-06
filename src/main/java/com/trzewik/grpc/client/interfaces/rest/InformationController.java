package com.trzewik.grpc.client.interfaces.rest;

import com.trzewik.grpc.client.domain.information.InformationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class InformationController {
    private final InformationService informationService;

    @GetMapping(value = "/information/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getInformation(@PathVariable(value = "id") String id) {
        log.info("Get information request with id: [{}]", id);
        informationService.getInformation(id);
        return id;
    }

    @GetMapping(value = "/stream/information/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String streamInformation(@PathVariable(value = "id") String id) {
        log.info("Stream information request with id: [{}]", id);
        informationService.startStream(id);
        return id;
    }
}
