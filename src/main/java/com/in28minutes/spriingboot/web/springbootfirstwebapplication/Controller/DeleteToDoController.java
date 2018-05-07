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

public class DeleteToDoController {

    @Autowired
    ToDoService toDoService;

    @RequestMapping(value = "/delete", method = RequestMethod.GET)

    public String deleteToDo(@RequestParam int id){

        toDoService.deleteToDoForUser(id);
        return"redirect:/todo";
    }
}



