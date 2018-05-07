package com.in28minutes.spriingboot.web.springbootfirstwebapplication.Controller;


import com.in28minutes.spriingboot.web.springbootfirstwebapplication.Service.ToDoService;
import com.in28minutes.spriingboot.web.springbootfirstwebapplication.Service.TodoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@SessionAttributes("name")

public class AddToDoControler {

    @Autowired
    ToDoService toDoService;


@RequestMapping(value = "/add", method = RequestMethod.GET)

    String sendToAddToDo(TodoUser todoUser){
    return "add";
    }


@RequestMapping(value = "/add", method = RequestMethod.POST)


    String addToDo(@RequestParam String toDoName, ModelMap modelMap, @Valid TodoUser todoUser, BindingResult bindingResult) {

    if(bindingResult.hasErrors()) return "add";

    toDoService.addToDoForUser((String) modelMap.get("name"),toDoName);

    return "redirect:/todo";

}


}

