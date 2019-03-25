package com.spriingboot.springbootfirstwebapplication.Controller;

import com.spriingboot.springbootfirstwebapplication.Service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")

public class DeleteToDoController {

    @Autowired
    ToDoService toDoService;

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteToDo(@RequestParam int id) {

        toDoService.deleteToDoForUser(id);
        return "redirect:/todo";
    }
}



