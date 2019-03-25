package com.spriingboot.springbootfirstwebapplication.Service;

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

            if (toDoUser.getId() == id) {
                return toDoUser;
            }
        }
        return null;
    }

    public void updatetoDoForUser(TodoUser todoUser) {
        for (TodoUser toDoUsers : todoUserList) {

            if (toDoUsers.getId() == todoUser.getId()) {
                toDoUsers.setToDoName(todoUser.getToDoName());
                toDoUsers.setFinished(todoUser.getFinished());
                toDoUsers.setTargetDate(todoUser.getTargetDate());
            }
        }
    }


    public void addToDoForUser(String userName, String toDoName, Date date) {
        todoUserList.add(new TodoUser(userName, toDoName, false, date));
    }

    public void deleteToDoForUser(int id) {
        Iterator<TodoUser> iteratorTodoUser = todoUserList.iterator();
        while (iteratorTodoUser.hasNext()) {
            if (iteratorTodoUser.next().getId() == id) iteratorTodoUser.remove();
        }
    }
}
