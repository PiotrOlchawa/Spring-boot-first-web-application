package com.in28minutes.spriingboot.web.springbootfirstwebapplication.Controller;

import com.in28minutes.spriingboot.web.springbootfirstwebapplication.Service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")

public class ToDoControler {

    @Autowired
    ToDoService toDoService;

    @RequestMapping(value = "/ToDo", method = RequestMethod.GET)
    public String showToDo(ModelMap modelMap) {
        String name = (String) modelMap.get("name");
    modelMap.put("todo",toDoService.getToDoForUser(name));
    return "todo";
    }
}
