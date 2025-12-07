package com.example.studytool;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class pomodoroTimer {
    private timerSettings settings;
    private Timeline timeline;
    private String phase;
    private int remainingSeconds;
    private int currentRepetition;

    public pomodoroTimer(timerSettings settings){
        this.settings = settings;
        this.phase = "STUDY";
        this.remainingSeconds = settings.getStudyTime() * 60;
        this.currentRepetition = 1;

        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e->tick()));
        timeline.setCycleCount(Timeline.INDEFINITE);
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
        remainingSeconds--;
        if(remainingSeconds<=0){
            switchPhase();
        }
    }

    private void switchPhase(){
        if(phase.equals("STUDY")){
            if(currentRepetition >= settings.getRepetition()){
                timeline.stop();
                return;
            }
            phase = "BREAK";
            remainingSeconds = settings.getBreakTime()*60;
        } else {
            currentRepetition++;
            phase = "STUDY";
            remainingSeconds = settings.getStudyTime()*60;
        }
    }

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
