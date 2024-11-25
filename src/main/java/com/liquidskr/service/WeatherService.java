package com.liquidskr.service;

import com.liquidskr.dto.WeatherResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

@Service
public class WeatherService {

    private final String apiKey = "12c38a4fb4c7789a951a5b39ee823355"; // OpenWeatherMap API 키

    public WeatherResponse getWeather(String city) {
        String url = String.format(
                "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric&lang=kr",
                city, apiKey
        );

        try {
            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(url, String.class);

            JSONObject json = new JSONObject(response);

            // DTO에 데이터를 매핑
            return new WeatherResponse(
                    json.getJSONObject("main").getDouble("temp"),
                    json.getJSONObject("main").getDouble("feels_like"),
                    json.getJSONObject("main").getInt("humidity"),
                    json.getJSONObject("wind").getDouble("speed"),
                    json.getJSONObject("wind").getInt("deg"),
                    json.getJSONObject("clouds").getInt("all"),
                    json.getJSONArray("weather").getJSONObject(0).getString("description"),
                    json.getJSONObject("sys").getLong("sunrise"),
                    json.getJSONObject("sys").getLong("sunset")
            );

        } catch (Exception e) {
            throw new RuntimeException("날씨 정보를 가져오는 데 실패했습니다: " + e.getMessage());
        }
    }
}
