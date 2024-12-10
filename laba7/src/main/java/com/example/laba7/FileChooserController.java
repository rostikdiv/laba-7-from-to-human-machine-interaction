package com.example.laba7;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileChooserController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_choose;

    @FXML
    private ImageView picture;

    @FXML
    private AnchorPane scenePane;

    @FXML
    void cgoose_picture(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Get image");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("image", "*.png"));

        Stage stage = (Stage) scenePane.getScene().getWindow();

        File file = fileChooser.showOpenDialog(stage);

        if (file !=null){
            URI uri = file.toURI();
            Image image = new Image(uri.toString());
            picture.setImage(image);
        }
    }

    @FXML
    void initialize() {
        assert btn_choose != null : "fx:id=\"btn_choose\" was not injected: check your FXML file 'file-chooser.fxml'.";
        assert picture != null : "fx:id=\"picture\" was not injected: check your FXML file 'file-chooser.fxml'.";

    }
}
