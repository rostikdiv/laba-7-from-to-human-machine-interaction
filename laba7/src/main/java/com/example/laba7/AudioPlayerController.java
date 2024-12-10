package com.example.laba7;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class AudioPlayerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Slider volume;

    @FXML
    private ProgressBar AudioProgress;

    @FXML
    private Label label_audio;

    private File file;
    private File[] files;
    private Media media;
    private MediaPlayer mediaPlayer;


    private ArrayList<File> songs;
    private int songNumber;

    @FXML
    void play(ActionEvent event) {
        mediaPlayer.play();
        label_audio.setText(songs.get(songNumber).getName());
    }

    @FXML
    void pause(ActionEvent event) {
        mediaPlayer.pause();
        label_audio.setText(songs.get(songNumber).getName());
    }

    @FXML
    void next(ActionEvent event) {
        if (songNumber < songs.size() - 1) {
            songNumber++;
            mediaPlayer.stop();

            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            label_audio.setText(songs.get(songNumber).getName());
            mediaPlayer.play();
            label_audio.setText(songs.get(songNumber).getName());
        } else {
            songNumber = 0;
            mediaPlayer.stop();

            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            label_audio.setText(songs.get(songNumber).getName());
            mediaPlayer.play();
            label_audio.setText(songs.get(songNumber).getName());
        }
    }

    @FXML
    void previous(ActionEvent event) {
        if (songNumber > 0) {
            songNumber--;
            mediaPlayer.stop();

            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            label_audio.setText(songs.get(songNumber).getName());
            mediaPlayer.play();
            label_audio.setText(songs.get(songNumber).getName());
        } else {
            songNumber = songs.size() - 1;
            mediaPlayer.stop();

            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            label_audio.setText(songs.get(songNumber).getName());
            mediaPlayer.play();
            label_audio.setText(songs.get(songNumber).getName());
        }
    }




    @FXML
    void initialize() {
        assert volume != null : "fx:id=\"volume\" was not injected: check your FXML file 'audio-player.fxml'.";
        assert AudioProgress != null : "fx:id=\"AudioProgress\" was not injected: check your FXML file 'audio-player.fxml'.";
        assert label_audio != null : "fx:id=\"label_audio\" was not injected: check your FXML file 'audio-player.fxml'.";

        file = new File("src/main/resources/music");
        files = file.listFiles();


        songs = new ArrayList<File>();

        if (files != null){
            for (File f: files){
                songs.add(f);
                System.out.println(f);
            }
        }


       playNextSong();
    }
    private void playNextSong() {
        media = new Media(songs.get(songNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(media);

        // Оновлення значення ProgressBar при відтворенні
        mediaPlayer.currentTimeProperty().addListener((observable, oldValue, newValue) -> {
            double progress = newValue.toSeconds() / media.getDuration().toSeconds();
            AudioProgress.setProgress(progress);
        });

        // Додавання слухача для натискання на ProgressBar
        AudioProgress.setOnMouseClicked(event -> {
            double clickPosition = event.getX(); // Позиція кліку по ProgressBar
            double progress = clickPosition / AudioProgress.getWidth(); // Вираховуємо прогрес на основі кліку
            double newTimeInSeconds = progress * media.getDuration().toSeconds(); // Новий час для відтворення
            mediaPlayer.seek(Duration.seconds(newTimeInSeconds)); // Переміщаємо програвання
        });

        volume.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                mediaPlayer.setVolume(volume.getValue() * 0.01);
            }
        });

        // Додати логіку для відтворення наступної пісні
        mediaPlayer.setOnEndOfMedia(() -> {
            songNumber = (songNumber + 1) % songs.size();  // Переміщаємось до наступної пісні
            playNextSong();  // Завантажуємо і відтворюємо наступну пісню
        });

        mediaPlayer.play();  // Починаємо відтворення пісні
    }
}
