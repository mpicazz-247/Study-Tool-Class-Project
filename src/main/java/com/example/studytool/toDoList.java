package com.example.studytool;

import java.util.ArrayList;
import java.util.List;

public class toDoList {
    //creates a dynamic array list that can be changes as
    //user adds or deletes tasks
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task t){
        tasks.add(t);
    } //adds a task to list
    public void removeTask(Task t){
        tasks.remove(t);
    }//removes a task from list

    public List<Task> getTasks(){
        return tasks;
    }//returns entire array of tasks
}
