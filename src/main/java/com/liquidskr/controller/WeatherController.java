package com.liquidskr.controller;

import com.liquidskr.dto.WeatherResponse;
import com.liquidskr.service.WeatherService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/api/weather")
    public WeatherResponse getWeather(@RequestParam String city) {
        return weatherService.getWeather(city);
    }
}
