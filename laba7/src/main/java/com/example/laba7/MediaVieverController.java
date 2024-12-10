package com.example.laba7;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;


public class MediaVieverController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MediaView media_view;

    @FXML
    private Button btn_reset;

    @FXML
    private Button btn_play;

    @FXML
    private Button btn_pause;

    private File file;
    private File[] files;
    private Media media;
    private MediaPlayer mediaPlayer;

    private ArrayList<File> sounds;
    private int songNumber;

    @FXML
    void play(ActionEvent event) {
        mediaPlayer.play();

    }

    @FXML
    void pause(ActionEvent event) {
        mediaPlayer.pause();
    }

    @FXML
    void reset(ActionEvent event) {
        if(mediaPlayer.getStatus() != MediaPlayer.Status.READY) {
            mediaPlayer.seek(Duration.seconds(0.0));
            mediaPlayer.play();
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        assert media_view != null : "fx:id=\"media_view\" was not injected: check your FXML file 'media-viever.fxml'.";
        assert btn_reset != null : "fx:id=\"btn_reset\" was not injected: check your FXML file 'media-viever.fxml'.";
        assert btn_play != null : "fx:id=\"btn_play\" was not injected: check your FXML file 'media-viever.fxml'.";
        assert btn_pause != null : "fx:id=\"btn_pause\" was not injected: check your FXML file 'media-viever.fxml'.";



        file = new File("src/main/resources/com/example/media.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        media_view.setMediaPlayer(mediaPlayer);
        System.out.println("---");
    }
}
 