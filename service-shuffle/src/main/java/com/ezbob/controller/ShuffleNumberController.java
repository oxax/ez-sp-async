package com.ezbob.controller;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ezbob.service.LogService;

@RestController
@RequestMapping("/api")
@EnableAsync
public class ShuffleNumberController {

    @Autowired
    private LogService logService;
    
    @PostMapping("/shuffle")
    public ResponseEntity<String> shuffleNumber(@RequestParam int number) {
        if(number < 1 || number > 1000) {
            return ResponseEntity.badRequest().body("Number must be between 1 and 1000");
        }


        logService.logRequest("Shuffle request for number: " + number);
        Integer[] shuffledArray = shuffleArray(number);
        logService.logRequest("Shuffled array: " + Arrays.toString(shuffledArray));
        return ResponseEntity.ok(Arrays.toString(shuffledArray));
    }

    private Integer[] shuffleArray(int number) {

        Integer[] array = new Integer[number];
        for (int i = 0; i < number; i++) {
            array[i] = i + 1;
        }


        Random random = new Random();
        for (int i = 0; i < number; i++) {
            int randomIndex = random.nextInt(number);
            int temp = array[randomIndex];
            array[randomIndex] = array[i];
            array[i] = temp;
        }

        return array;
    }
}
