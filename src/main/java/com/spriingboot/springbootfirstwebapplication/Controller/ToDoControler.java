package com.spriingboot.springbootfirstwebapplication.Controller;

import com.spriingboot.springbootfirstwebapplication.Service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")


public class ToDoControler {

  /*  @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date - dd/MM/yyyy
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
    }*/

    @Autowired
    ToDoService toDoService;

    @RequestMapping(value = "/todo", method = RequestMethod.GET)
    public String showToDo(ModelMap modelMap) {
        String name = (String) modelMap.get("name");
        modelMap.put("todo", toDoService.getToDoForUser(name));
        return "todo";
    }
}
