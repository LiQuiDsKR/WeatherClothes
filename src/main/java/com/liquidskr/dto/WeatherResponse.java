package com.liquidskr.dto;

public class WeatherResponse {
    private double temp;
    private double feelsLike;
    private int humidity;
    private double windSpeed;
    private int windDeg;
    private int clouds;
    private String description;
    private long sunrise;
    private long sunset;

    // 기본 생성자
    public WeatherResponse() {}

    // 모든 필드를 받는 생성자
    public WeatherResponse(double temp, double feelsLike, int humidity, double windSpeed, int windDeg,
                           int clouds, String description, long sunrise, long sunset) {
        this.temp = temp;
        this.feelsLike = feelsLike;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.windDeg = windDeg;
        this.clouds = clouds;
        this.description = description;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    // Getter와 Setter
    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getWindDeg() {
        return windDeg;
    }

    public void setWindDeg(int windDeg) {
        this.windDeg = windDeg;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    public long getSunset() {
        return sunset;
    }

    public void setSunset(long sunset) {
        this.sunset = sunset;
    }
}
