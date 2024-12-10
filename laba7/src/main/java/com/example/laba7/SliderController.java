package com.example.laba7;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class SliderController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label myLabel;

    @FXML
    private Slider mySlider;

    @FXML
    void changed(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert myLabel != null : "fx:id=\"myLabel\" was not injected: check your FXML file 'slider.fxml'.";
        assert mySlider != null : "fx:id=\"mySlider\" was not injected: check your FXML file 'slider.fxml'.";


        mySlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                int score = (int) mySlider.getValue();
                myLabel.setText("Ваша оцінка: "+score + " балів");
            }
        });
    }
}
