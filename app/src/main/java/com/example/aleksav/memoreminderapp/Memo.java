package com.example.aleksav.memoreminderapp;

import java.util.Date;

public class Memo {

    public enum PRIORITY { HIGH, MEDIUM, LOW }

    public int id;
    public String name;
    public String text;
    public PRIORITY priority;
    public boolean isDone;
    public String date;

    public Memo(int id, String name, String text, PRIORITY priority, boolean isDone, String date) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.priority = priority;
        this.isDone = isDone;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public PRIORITY getPriority() {
        return priority;
    }

    public void setPriority(PRIORITY priority) {
        this.priority = priority;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
