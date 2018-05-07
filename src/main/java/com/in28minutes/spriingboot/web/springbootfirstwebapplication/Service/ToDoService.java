package com.in28minutes.spriingboot.web.springbootfirstwebapplication.Service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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

    public TodoUser toDoForUser(int id) {

        for (TodoUser toDoUser : todoUserList) {

            if (toDoUser.getId() == id ) {
                return toDoUser;
            }
        }
        return null;


    }

    public void updatetoDoForUser(int id,String toDo) {

        for (TodoUser toDoUser : todoUserList) {

            if (toDoUser.getId() == id ) {
                toDoUser.setToDoName(toDo);
                toDoUser.setTargetDate(new Date());
            }
        }



    }

    public void addToDoForUser(String userName,String toDoName) {
        todoUserList.add(new TodoUser(userName,toDoName,false,new Date()));
    }

    public void deleteToDoForUser(int id){
        Iterator<TodoUser> iteratorTodoUser = todoUserList.iterator();
        while(iteratorTodoUser.hasNext()){
            if(iteratorTodoUser.next().getId() == id) iteratorTodoUser.remove();
        }

    }




}
