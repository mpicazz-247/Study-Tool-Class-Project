package com.example.studytool;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class mainController {
    // pomodoro timer UI
    @FXML private Label timerLabel;
    @FXML private Button startStopButton;
    @FXML private Button skipButton;
    @FXML private Button resetButton;
    @FXML private RadioButton mode25_5;
    @FXML private RadioButton mode50_10;
    @FXML private ComboBox<Integer> repetetionSelector;
    // to-do list UI
    @FXML private Button addButton;
    @FXML private Button toggleButton;
    @FXML private Button removeButton;
    @FXML private TextField taskInput;
    @FXML private ListView<task> taskListView;
    //data
    private ObservableList<task> tasks = FXCollections.observableArrayList();
    private timerSettings settings;
    private pomodoroTimer timer;

    @FXML
    public void intialize(){
        //setting the default values of the timer to
        // 1 repetition, 5 minutes of break, and 25 minutes of studying
        settings = new timerSettings(1,5,25);
        timer = new pomodoroTimer(settings, () -> {
            timerLabel.setText(timer.getRemainingSeconds()/60+ " (" + timer.getPhase() + ")");
        });
    }
}
