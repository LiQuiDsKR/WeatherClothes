package com.liquidskr.controller;

import com.liquidskr.dto.ItemDTO;
import com.liquidskr.service.ClothesRecommendationService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClothesRecommendationController {

    private final ClothesRecommendationService recommendationService;

    public ClothesRecommendationController(ClothesRecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/api/clothes-recommendation")
    public List<ItemDTO> getClothesRecommendation(
            @RequestParam double temp,
            @RequestParam double windSpeed,
            @RequestParam int humidity,
            @RequestParam int cloudiness) {
        return recommendationService.getClothesRecommendation(temp, windSpeed, humidity, cloudiness);
    }
}
