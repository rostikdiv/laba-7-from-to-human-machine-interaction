package com.example.laba7;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class ColorPickerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private ColorPicker color_picker;

    @FXML
    void changeColor(ActionEvent event) {

        Color myColor = color_picker.getValue();
        scenePane.setBackground(new Background(new BackgroundFill(myColor,null, null)));

    }

    @FXML
    void initialize() {
        assert scenePane != null : "fx:id=\"scenePane\" was not injected: check your FXML file 'color-picker.fxml'.";
        assert color_picker != null : "fx:id=\"color_picker\" was not injected: check your FXML file 'color-picker.fxml'.";

    }
}
