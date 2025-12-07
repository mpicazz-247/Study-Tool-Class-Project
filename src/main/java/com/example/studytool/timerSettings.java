package com.example.studytool;

public class timerSettings {
    private int repetition; //number of times pomodoro timer repeats itself
    private int breakTime; //length of breaks in minutes
    private int studyTime; //length of study intervals in minutes
    //constructor to allow settings objects to be created later in other classes
    public timerSettings(int repetition, int breakTime, int studyTime){
        this.repetition = repetition;
        this.breakTime = breakTime;
        this.studyTime = studyTime;
    }
//getters to allow other classes to read these values
    public int getRepetition(){
        return repetition;
    }
    public int getBreakTime(){
        return breakTime;
    }
    public int getStudyTime(){
        return studyTime;
    }
}
