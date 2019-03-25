package com.spriingboot.springbootfirstwebapplication.Controller;

import com.spriingboot.springbootfirstwebapplication.Service.ToDoService;
import com.spriingboot.springbootfirstwebapplication.Service.TodoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@SessionAttributes("name")

public class UpdateToDoController {

    @Autowired
    ToDoService toDoService;

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateGetToDo(ModelMap modelMap, @RequestParam int id) {
        TodoUser todoUser = toDoService.toDoForUser(id);
        modelMap.put("todoUser", todoUser);
        return "update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateSetToDo(ModelMap modelMap, @Valid TodoUser todoUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "update";

        todoUser = (TodoUser) modelMap.get("todoUser");
        toDoService.updatetoDoForUser(todoUser);
        return "redirect:/todo";


    }
}



