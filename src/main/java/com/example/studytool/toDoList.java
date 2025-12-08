package com.example.studytool;

import java.util.ArrayList;
import java.util.List;

public class toDoList {
    //creates a dynamic array list that can be changes as
    //user adds or deletes tasks
    private List<task> tasks = new ArrayList<>();

    public void addTask(task t){
        tasks.add(t);
    } //adds a task to list
    public void removeTask(int index){
        tasks.remove(index);
    }//removes a task from list

    public List<task> getTasks(){
        return tasks;
    }//returns entire array of tasks
}
