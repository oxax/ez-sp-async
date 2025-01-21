package com.ezbob.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LogController {
    private static final Logger logger = LoggerFactory.getLogger(LogController.class);

    @PostMapping("/log")
    public String logRequest(@RequestBody String request) {
        logger.info("Request received: " + request);
        return "Request logged";
    }
}
