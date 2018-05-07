package com.in28minutes.spriingboot.web.springbootfirstwebapplication.Service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class TodoUser {

    static int countId = 0;


    private int id;
    private String username;

    private boolean finished;
    private Date targetDate;


    @Size(min = 10,message = "Pole powinno zawierać minimum 10 znaków")
    private String toDoName;

    public TodoUser() {
        super();
    }

    public TodoUser(String username, String toDoName, boolean finished, Date targetDate) {
        this.username = username;
        this.toDoName = toDoName;
        this.finished = finished;
        this.targetDate = targetDate;
        countId++;
        this.id = countId;
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

    public boolean getFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

