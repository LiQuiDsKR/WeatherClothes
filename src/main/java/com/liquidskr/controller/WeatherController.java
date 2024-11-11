package com.liquidskr.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.json.JSONObject;

@RestController
public class WeatherController {

    private final String apiKey = "12c38a4fb4c7789a951a5b39ee823355"; // 무료 API 키 니까 그냥 노출함
    private final ClothesRecommendation clothesRecommendation = new ClothesRecommendation();

    @CrossOrigin(origins = "*")
    @GetMapping("/weather")
    public ResponseEntity<String> getWeather(@RequestParam String city) {
        String url = String.format(
                "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric&lang=kr",
                city, apiKey
        );

        try {
            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(url, String.class);

            JSONObject json = new JSONObject(response);

            double temp = json.getJSONObject("main").getDouble("temp");
            double feelsLike = json.getJSONObject("main").getDouble("feels_like");
            int humidity = json.getJSONObject("main").getInt("humidity");
            double windSpeed = json.getJSONObject("wind").getDouble("speed");
            int windDeg = json.getJSONObject("wind").getInt("deg");
            int clouds = json.getJSONObject("clouds").getInt("all");
            String description = json.getJSONArray("weather").getJSONObject(0).getString("description");
            long sunrise = json.getJSONObject("sys").getLong("sunrise");
            long sunset = json.getJSONObject("sys").getLong("sunset");

            JSONObject result = new JSONObject();
            result.put("temp", temp);
            result.put("feelsLike", feelsLike);
            result.put("humidity", humidity);
            result.put("windSpeed", windSpeed);
            result.put("windDeg", windDeg);
            result.put("clouds", clouds);
            result.put("description", description);
            result.put("sunrise", sunrise);
            result.put("sunset", sunset);

            return ResponseEntity.ok(result.toString());

        } catch (Exception e) {
            return ResponseEntity.status(500).body("날씨 정보를 가져오는 데 실패했습니다.");
        }
    }
}
