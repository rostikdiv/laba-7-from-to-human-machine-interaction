package com.example.laba7;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatePickerController {
    @FXML
    private DatePicker myDatePicker;

    @FXML
    private Label dataLabel1;

    @FXML
    void getDate(ActionEvent event) {
        LocalDate myDate = myDatePicker.getValue();
        System.out.println(myDate.toString());
        String dateFormatter =myDate.format(DateTimeFormatter.ofPattern("dd.MM.yyy"));
        dataLabel1.setText(dateFormatter);
    }
}
