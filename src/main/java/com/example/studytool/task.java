package com.example.studytool;

public class task {
    private String title; //task name
    private boolean completed; //task status
    //constructor to make task objects
    public task(String title) {
        this.title = title;
        this.completed = false; //starts as false
    }
    //getters and setters.
    public String getTitle() {
        return title;
    }
    public boolean getCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed){
        this.completed = completed;
    } //setter for completed to turn on and off

}
