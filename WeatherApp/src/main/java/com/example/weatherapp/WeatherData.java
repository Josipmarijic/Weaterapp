package com.example.weatherapp;

public class WeatherData {
    private String city;
    private String description;
    private Double temp;
    private String icon;

    public WeatherData() {
    }

    public WeatherData(String city, String description, Double temp, String icon) {
        this.city = city;
        this.description = description;
        this.temp = temp;
        this.icon = icon;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = "http://openweathermap.org/img/w/" + icon + ".png";
    }
}
