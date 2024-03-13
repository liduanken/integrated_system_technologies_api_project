package com.istl.interview.test.service;

import com.istl.interview.test.dto.TemperatureDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class TemperatureService {

    //region Attributes

    private TemperatureDTO previousTemperature;

    private final Random random = new Random();

    //endregion

    //region Methods

    public TemperatureDTO getPreviousTemperature() {
        return previousTemperature;
    }

    /**
     * Get the current temperature
     *
     * @return current temperature
     */
    public TemperatureDTO currentTemperature() {
        //create the temperature
        TemperatureDTO currentTemperature = new TemperatureDTO(LocalDateTime.now(), randomTemperature());

        //save to local variable as now the previous temperature
        previousTemperature = currentTemperature;

        //return value
        return currentTemperature;
    }

    /**
     * Create a random temperature for testing
     *
     * @return a random float number
     */
    private float randomTemperature() {

        float low = 5f;
        float high = 25f;

        //create a random temperature close to the previous value
        if(previousTemperature != null) {
            low = previousTemperature.getValue() - 2f;
            high = previousTemperature.getValue() + 2f;
        }

        return low + random.nextFloat() * (high - low);
    }

    //endregion
}
