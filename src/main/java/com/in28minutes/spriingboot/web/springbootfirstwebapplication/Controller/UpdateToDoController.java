package com.in28minutes.spriingboot.web.springbootfirstwebapplication.Controller;

import com.in28minutes.spriingboot.web.springbootfirstwebapplication.Service.ToDoService;
import com.in28minutes.spriingboot.web.springbootfirstwebapplication.Service.TodoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

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
        System.out.println("---------------------------------" + todoUser.getToDoName() + "---------Id------" + todoUser.getId());
        toDoService.updatetoDoForUser(todoUser);
        return "redirect:/todo";


    }
}



