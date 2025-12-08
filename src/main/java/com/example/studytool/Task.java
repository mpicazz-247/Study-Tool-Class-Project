package com.example.studytool;

public class Task {
    private String title; //task name
    private boolean completed; //task status
    //constructor to make task objects
    public Task(String title) {
        this.title = title;
        this.completed = false; //starts as false
    }
    //getters and setters.
    public String getTitle() {
        return title;
    }
    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed){
        this.completed = completed;
    } //setter for completed to turn on and off

    @Override
    public String toString(){
        return completed ? "[1]"+ title : "[0]"+title;

    }

}
