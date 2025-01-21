package com.ezbob.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.AsyncRestTemplate;

@Service
public class LogService {

    @Value("${service.log.url}")
    private String logServiceUrl;

    private final AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate();

    public CompletableFuture<Void> logRequest(String message) {
        return CompletableFuture.runAsync(() -> {
            asyncRestTemplate.postForEntity(logServiceUrl, new HttpEntity<>(message), String.class);
        });
    }
}
