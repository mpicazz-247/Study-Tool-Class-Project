module com.example.studytool {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.studytool to javafx.fxml;
    exports com.example.studytool;
}