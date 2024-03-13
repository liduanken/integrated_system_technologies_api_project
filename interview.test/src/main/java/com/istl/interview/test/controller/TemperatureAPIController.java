package com.istl.interview.test.controller;

import com.istl.interview.test.dto.TemperatureDTO;
import com.istl.interview.test.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/temperature")
public class TemperatureAPIController {

    //region Attributes

    @Autowired
    private TemperatureService temperatureService;

    //endregion

    //region Methods

    @GetMapping("/current")
    public ResponseEntity<?> getCurrentTemperature() {
        return ResponseEntity.ok(temperatureService.currentTemperature());
    }

    @GetMapping("/previous")
    public ResponseEntity<?> getPreviousTemperature() {
        TemperatureDTO temperature = temperatureService.getPreviousTemperature();

        if(temperature != null) {
            return ResponseEntity.ok(temperature);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //endregion
}
