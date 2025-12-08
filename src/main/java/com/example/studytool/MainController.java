package com.example.studytool;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class MainController {
    // pomodoro timer UI
    @FXML private Label timerLabel;
    @FXML private Button startStopButton;
    @FXML private Button skipButton;
    @FXML private Button resetButton;
    @FXML private RadioButton mode25_5;
    @FXML private RadioButton mode50_10;
    @FXML private ComboBox<Integer> repetitionSelector;
    // to-do list UI
    @FXML private Button addButton;
    @FXML private Button toggleButton;
    @FXML private Button removeButton;
    @FXML private TextField taskInput;
    @FXML private ListView<Task> taskListView;
    //data
    private ObservableList<Task> tasks = FXCollections.observableArrayList();
    private TimerSettings settings;
    private PomodoroTimer timer;

    @FXML
    public void initialize() {
        //Radio buttons group
        ToggleGroup modeGroup = new ToggleGroup();
        mode25_5.setToggleGroup(modeGroup);
        mode50_10.setToggleGroup(modeGroup);
        mode25_5.setSelected(true);
        //setting the default values of the timer to
        // 1 repetition, 5 minutes of break, and 25 minutes of studying
        settings = new TimerSettings(1, 5, 25);
        timer = new PomodoroTimer(settings, () -> {
            timerLabel.setText(timer.getFormattedTime() + " (" + timer.getPhase() + ")");
        });

        repetitionSelector.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8));
        repetitionSelector.setValue(1);

        taskListView.setItems(tasks);
        timerLabel.setText(timer.getFormattedTime());
    }

    //Timer actions
    @FXML
    private void startStopTimer(){
        if(timer.isRunning()){
            timer.stop();
            startStopButton.setText("Start");
        }else{
            timer.start();
            startStopButton.setText("Stop");
        }
    }
    @FXML
    private void skipButton(){
        timer.skip();
    }
    @FXML
    private void resetTimer(){
        timer.reset();
        startStopButton.setText("Start");
    }
    @FXML
    private void handleMode25_5(){
        settings = new TimerSettings(repetitionSelector.getValue(), 5, 25);
        timer.resetWithSettings(settings);
    }
    @FXML
    private void handleMode50_10(){
        settings = new TimerSettings(repetitionSelector.getValue(), 10, 50);
        timer.resetWithSettings(settings);
    }
    //To-Do actions
    @FXML
    private void addTask(){
        String title = taskInput.getText().trim();
        if(!title.isEmpty()){
            tasks.add(new Task(title));
            taskInput.clear();
        }
    }
    @FXML
    private void toggleButton(){
        Task selected = taskListView.getSelectionModel().getSelectedItem();
        if(selected !=null){
            selected.setCompleted(!selected.isCompleted());
            taskListView.refresh();
        }
    }
    @FXML
    private void removeButton(){
        Task selected = taskListView.getSelectionModel().getSelectedItem();
        if(selected != null){
            tasks.remove(selected);
        }
    }
}
