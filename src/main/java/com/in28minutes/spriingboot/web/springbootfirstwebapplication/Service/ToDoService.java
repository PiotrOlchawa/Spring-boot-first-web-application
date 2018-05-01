package com.in28minutes.spriingboot.web.springbootfirstwebapplication.Service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ToDoService {

    static List<TodoUser> todoUserList = new ArrayList<>();

    static {
        todoUserList.add(new TodoUser("piotr", "Learn Java Basics", false, new Date()));
        todoUserList.add(new TodoUser("piotr", "Learn Java Advanced", false, new Date()));
        todoUserList.add(new TodoUser("piotr", "Learn Spring", false, new Date()));
        todoUserList.add(new TodoUser("piotr", "Learn Hibernate", false, new Date()));
    }

    public List<TodoUser> getToDoForUser(String userName) {
        List<TodoUser> selectedTodoUserList = new ArrayList<>();
        for (TodoUser toDoUser : todoUserList) {

            if (toDoUser.getUsername().equals("piotr")) {
                selectedTodoUserList.add(toDoUser);
            }
        }
        return selectedTodoUserList;


    }

    public void addToDoForUser(String userName,String toDoName) {
        todoUserList.add(new TodoUser(userName,toDoName,false,new Date()));
    }

}
