module com.example.laba7 {
    requires javafx.controls;
    requires javafx.fxml;

    requires javafx.media;  // Додайте цей рядок


    opens com.example.laba7 to javafx.fxml;
    exports com.example.laba7;
}