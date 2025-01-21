package com.ezbob.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class LogControllerTests {
    private final LogController logController = new LogController();
    private final MockMvc mockMvc = MockMvcBuilders.standaloneSetup(logController).build();

    @Test
    public void testLogRequest() throws Exception {
        mockMvc.perform(post("/api/log")
                .contentType(MediaType.APPLICATION_JSON)
                .content("Test request body"))
                .andExpect(status().isOk());
    }

}
