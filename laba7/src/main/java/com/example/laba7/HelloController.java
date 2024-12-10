package com.example.laba7;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button slider;

    @FXML
    private Button media_viever;

    @FXML
    private Button datePicker;

    @FXML
    private Button file_chooser;

    @FXML
    private Button colorPicker;

    @FXML
    void open_date_picler(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("date-picker.fxml"));
        try {
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.setTitle("Test");
            stage.setResizable(true);
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void open_ColorPicker(ActionEvent event) {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("color-picker.fxml"));
        try {
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.setTitle("Test");
            stage.setResizable(true);
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void open_slider(ActionEvent event) {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("slider.fxml"));
        try {
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.setTitle("Test");
            stage.setResizable(true);
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void open_file_chooser(ActionEvent event) {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("file-chooser.fxml"));
        try {
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.setTitle("Test");
            stage.setResizable(true);
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void open_media_viever(ActionEvent event) {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("media-viever.fxml"));
        try {
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.setTitle("Test");
            stage.setResizable(true);
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void openAudioPlayer(ActionEvent event) {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("audio-player.fxml"));
        try {
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.setTitle("Test");
            stage.setResizable(true);
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void initialize() {
        assert slider != null : "fx:id=\"slider\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert media_viever != null : "fx:id=\"media_viever\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert datePicker != null : "fx:id=\"datePicker\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert file_chooser != null : "fx:id=\"file_chooser\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert colorPicker != null : "fx:id=\"colorPicker\" was not injected: check your FXML file 'hello-view.fxml'.";

    }
}