package com.ezbob.controller;

import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.ezbob.service.LogService;

@SpringBootTest
public class ShuffleNumberControllerTest {

    @Mock
    private LogService logService;


    @InjectMocks
    private ShuffleNumberController shuffleNumberController;

    @BeforeEach
    public void initMocks() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testShuffleNumber_ValidInput() {
        int number = 10;

        when(logService.logRequest(anyString())).thenReturn(CompletableFuture.completedFuture(null)); 
        ResponseEntity<String> response = shuffleNumberController.shuffleNumber(number);
        
        assertEquals(200, response.getStatusCodeValue()); // Verify response status is OK 200
    }

    @Test
    public void testShuffleNumber_InvalidInput_TooHigh() {
        int number = 1001;

        ResponseEntity<String> response = shuffleNumberController.shuffleNumber(number);
        
        assertEquals(400, response.getStatusCodeValue()); // Verify response status is Bad Request 400
        assertEquals("Number must be between 1 and 1000", response.getBody()); // Verify response message
    }

    @Test
    public void testShuffleNumber_InvalidInput_TooLow() {
        int number = 0;

        ResponseEntity<String> response = shuffleNumberController.shuffleNumber(number);
        
        assertEquals(400, response.getStatusCodeValue()); // Verify response status is Bad Request 400
        assertEquals("Number must be between 1 and 1000", response.getBody()); // Verify response message
    }

}
