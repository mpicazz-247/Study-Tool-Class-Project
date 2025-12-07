package com.example.studytool;

public class timerSettings {
    private int repetition;
    private int breakTime;
    private int studyTime;

    public timerSettings(int repetition, int breakTime, int studyTime){
        this.repetition = repetition;
        this.breakTime = breakTime;
        this.studyTime = studyTime;
    }

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
