package com.example.weatherapp;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class APICall {

    public WeatherData weatherData = new WeatherData();

    public WeatherData apiCall(String city) throws IOException, ParseException {

        


        String urlLink = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=d0a05f628d858bc96745ca318c31d4d4&units=metric";

        URL apiURL = new URL(urlLink);

        HttpURLConnection connection = (HttpURLConnection) apiURL.openConnection();
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setRequestMethod("GET");

        Scanner scanner = new Scanner(apiURL.openStream());

        String inputLine = "";


        while (scanner.hasNextLine()) {
            inputLine += scanner.nextLine();
        }

        scanner.close();

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(inputLine);


        JSONObject object = (JSONObject) jsonObject.get("main");

        JSONArray jsonArray = (JSONArray) jsonObject.get("weather");
        JSONObject object1 = (JSONObject) jsonArray.get(0);


        weatherData.setTemp((Double) object.get("temp"));
        weatherData.setDescription((String) object1.get("description"));
        weatherData.setIcon((String) object1.get("icon"));
        weatherData.setCity(city);


        return weatherData;
    }


}
