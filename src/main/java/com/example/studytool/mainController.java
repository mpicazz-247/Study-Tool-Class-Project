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
    public void intialize() {
        //setting the default values of the timer to
        // 1 repetition, 5 minutes of break, and 25 minutes of studying
        settings = new timerSettings(1, 5, 25);
        timer = new pomodoroTimer(settings, () -> {
            timerLabel.setText(timer.getFormattedTime() + " (" + timer.getPhase() + ")");
        });

        repetetionSelector.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8));
        repetetionSelector.setValue(1);

        taskListView.setItems(tasks);
        timerLabel.setText(timer.getFormattedTime());
    }
}
//Timer actions
@FXML
private void startStopTimer(){
    if("Start".equals(startStopButton.getText())){
        timer.start();
        startStopButton.setText("Stop");
    }else{
        timer.stop();
        startStopButton.setText("Start");
    }
}
@FXML
private void skipButton(){
    timer.skip();
}
@FXML
private void resetTimer){
    timer.reset();
    startStopButton.setText("Start");
}
//To-Do actions
@FXML
private void addTask(){
    String title = taskInput.getText();
    if(!title.isEmpty()){
        tasks.add(new task(title));
        taskInput.clear();
    }
}
@FXML
private void toggleButton(){
    task selected taskListView.getSelectionModel().getSelectedItem();
    if(selected !=null){
        selected.setCompleted(!selected.getCompleted());
        taskListView.refresh();
    }
}
@FXML
private void removeButton(){
    task selected = taskListView.getSelectionModel().getSelectedItem();
    if(selected != null){
        tasks.remove(selected);
    }
}