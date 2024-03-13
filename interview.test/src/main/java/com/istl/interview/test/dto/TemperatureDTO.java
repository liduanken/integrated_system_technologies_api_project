package com.istl.interview.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class TemperatureDTO {

    private final LocalDateTime timestamp;

    private final float value;

}
