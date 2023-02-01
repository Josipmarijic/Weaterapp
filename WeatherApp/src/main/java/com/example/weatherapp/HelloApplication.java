package com.example.weatherapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;


import java.io.IOException;

public class HelloApplication extends Application {
    public String citySearch;

    public static void main(String[] args) {
        launch();

    }

    @Override
    public void start(Stage stage) throws IOException, ParseException {

        Label label = new Label("Search by city name:");
        TextField textField = new TextField();
        Button button = new Button("Search");
        HBox hb = new HBox();
        hb.getChildren().addAll(label, textField, button);
        hb.setSpacing(10);
        WeatherData weatherData = new WeatherData();


        EventHandler<ActionEvent> search = e -> {
            citySearch = textField.getText();
            APICall callAPI = new APICall();
            try {
                callAPI.apiCall(textField.getText());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
            Image image = new Image(callAPI.weatherData.getIcon());
            ImageView imageView = new ImageView();
            imageView.setImage(image);
            imageView.setFitHeight(100);
            imageView.setFitWidth(100);
            Label label1 = new Label("The weather in " + callAPI.weatherData.getCity() + " is:");
            Label temp = new Label("The temprature is " + callAPI.weatherData.getTemp() + " celsius");


            Label description = new Label(callAPI.weatherData.getDescription());
            VBox vBox = new VBox();
            Group group = new Group();
            vBox.getChildren().addAll(imageView, label1, description, temp);


            Scene scene = new Scene(group, 400, 400);
            stage.setTitle("Hello!");
            group.getChildren().add(vBox);
            stage.setScene(scene);
            stage.show();
        };


        button.setOnAction(search);
        Group group = new Group();


        Scene scene = new Scene(group, 400, 400);
        stage.setTitle("Hello!");
        group.getChildren().add(hb);
        stage.setScene(scene);
        stage.show();
    }
}