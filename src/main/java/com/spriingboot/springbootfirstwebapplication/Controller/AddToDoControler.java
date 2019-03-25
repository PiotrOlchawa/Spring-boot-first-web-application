package com.spriingboot.springbootfirstwebapplication.Controller;


import com.spriingboot.springbootfirstwebapplication.Service.ToDoService;
import com.spriingboot.springbootfirstwebapplication.Service.TodoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@Controller
@SessionAttributes("name")

public class AddToDoControler {

    @Autowired
    ToDoService toDoService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    String viewAddToDo(TodoUser todoUser) {
        return "add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    String addToDo(@RequestParam String toDoName, @RequestParam Date targetDate, ModelMap modelMap, @Valid TodoUser todoUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "add";
        toDoService.addToDoForUser((String) modelMap.get("name"), toDoName, targetDate);
        return "redirect:/todo";

    }


}

