package com.liquidskr.controller;

public class ClothesRecommendation {

    public String getClothesRecommendation(double temp, double windSpeed, int humidity, int cloudiness) {
        StringBuilder recommendation = new StringBuilder();

        // 기온에 따른 옷차림 추천
        if (temp >= 28) {
            recommendation.append("민소매, 반팔, 반바지, 린넨 옷");
        } else if (temp >= 23) {
            recommendation.append("반팔, 얇은 셔츠, 반바지, 면바지");
        } else if (temp >= 20) {
            recommendation.append("블라우스, 긴팔 티셔츠, 면바지, 슬랙스");
        } else if (temp >= 17) {
            recommendation.append("얇은 가디건이나 니트, 맨투맨, 후드, 긴 바지");
        } else if (temp >= 12) {
            recommendation.append("자켓, 가디건, 청자켓, 니트, 스타킹, 청바지");
        } else if (temp >= 9) {
            recommendation.append("트렌치 코트, 야상, 점퍼, 스타킹, 기모 바지");
        } else if (temp >= 5) {
            recommendation.append("울 코트, 히트텍, 가죽 옷, 기모 바지");
        } else {
            recommendation.append("패딩, 두꺼운 코트, 누빔 옷, 기모, 목도리");
        }

        // 바람에 따른 추가 추천
        if (windSpeed >= 6) {
            recommendation.append(", 바람막이");
        } else if (windSpeed >= 3) {
            recommendation.append(", 가벼운 외투");
        }

        // 습도에 따른 조정
        if (humidity >= 80) {
            recommendation.append(" (습도가 높으니 가벼운 옷차림을 추천)");
        } else if (humidity <= 30) {
            recommendation.append(" (건조하니 보온에 유의하세요)");
        }

        // 구름량에 따른 조정
        if (cloudiness >= 50) {
            recommendation.append(" (구름이 많아 쌀쌀할 수 있습니다)");
        } else {
            recommendation.append(" (맑은 날씨입니다)");
        }

        return recommendation.toString();
    }
}
