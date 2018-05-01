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

public class AddToDoControler {

    @Autowired
    ToDoService toDoService;


@RequestMapping(value = "/add", method = RequestMethod.GET)

    String sendToAddToDo(){
    return "add";
    }

@RequestMapping(value = "/add", method = RequestMethod.POST)

    String addToDo(@RequestParam String toDoName,ModelMap modelMap) {

    toDoService.addToDoForUser((String) modelMap.get("name"),toDoName);
    modelMap.put("todo", toDoService.getToDoForUser((String) modelMap.get("name")));
    return "todo";
}


}

