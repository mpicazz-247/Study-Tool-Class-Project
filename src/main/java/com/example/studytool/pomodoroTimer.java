package com.example.studytool;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class pomodoroTimer {
    private timerSettings settings; //timer setting
    private Timeline timeline; //imported data type
    private String phase; //imported data type
    private int remainingSeconds; //remaining minutes*60
    private int currentRepetition; //current repetition in cycle
//constructor
    public pomodoroTimer(timerSettings settings){
        this.settings = settings;
        this.phase = "STUDY"; //starts off at study interval before break
        this.remainingSeconds = settings.getStudyTime() * 60;
        this.currentRepetition = 1;
        //create a timeline, ticks every second
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e->tick()));
        //make it loop indefinitely
        timeline.setCycleCount(Timeline.INDEFINITE); //
    }

    public void start(){
        timeline.play();
    }
    public void stop(){
        timeline.stop();
    }
    public void reset(){
        timeline.stop();
        phase = "STUDY";
        remainingSeconds = settings.getStudyTime()*60;
        currentRepetition=1;
    }
    public void skip(){
        switchPhase();
    }

    private void tick(){
        remainingSeconds--; //timer goes down by one seconds every second
        if(remainingSeconds<=0){ //checks to see if time left is zero or not
            switchPhase(); //phase is switched if yes
        }
    }

    private void switchPhase(){
        if(phase.equals("STUDY")){
            //checks to see if all repetitions
            if(currentRepetition >= settings.getRepetition()){
                timeline.stop(); //if completed the timer is stopped
                return;
            }
            phase = "BREAK"; //phase is switched
            remainingSeconds = settings.getBreakTime()*60; //break time in seconds is set
        } else { //after break time, one full repetition is complete
            currentRepetition++; //current repetition goes up by one
            phase = "STUDY"; //phase is switched
            remainingSeconds = settings.getStudyTime()*60; //study time in seconds is set
        }
    }
//getters
    public String getPhase(){
        return phase;
    }
    public int getRemainingSeconds(){
        return remainingSeconds;
    }
    public int getCurrentRepetition(){
        return currentRepetition;
    }

}
