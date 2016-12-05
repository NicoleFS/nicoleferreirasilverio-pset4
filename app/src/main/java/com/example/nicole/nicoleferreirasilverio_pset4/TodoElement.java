package com.example.nicole.nicoleferreirasilverio_pset4;

/**
 * Created by Nicole on 5-12-2016.
 */

public class TodoElement {
    public String id;
    public String task;

    public TodoElement(){
        id = "";
        task = "";
    }

    public void setId(String id){
        this.id = id;
    }

    public void setTask(String task){
        this.task = task;
    }

    public String getId(){
        return this.id;
    }

    public String getTask(){
        return this.task;
    }
}
