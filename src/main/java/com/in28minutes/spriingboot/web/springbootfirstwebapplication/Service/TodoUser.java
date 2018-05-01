package com.in28minutes.spriingboot.web.springbootfirstwebapplication.Service;

import java.util.Date;

public class TodoUser {

    String username;
    String toDoName;
    boolean finished;
    Date targetDate;

    public TodoUser(String username, String toDoName, boolean finished, Date targetDate) {
        this.username = username;
        this.toDoName = toDoName;
        this.finished = finished;
        this.targetDate = targetDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToDoName() {
        return toDoName;
    }

    public void setToDoName(String toDoName) {
        this.toDoName = toDoName;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    @Override
    public String toString() {
        return "TodoUser{" +
                "username='" + username + '\'' +
                ", toDoName='" + toDoName + '\'' +
                ", finished=" + finished +
                ", targetDate=" + targetDate +
                '}';
    }
}

