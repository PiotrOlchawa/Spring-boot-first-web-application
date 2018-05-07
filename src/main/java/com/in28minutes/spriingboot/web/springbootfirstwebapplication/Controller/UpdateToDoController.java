package com.in28minutes.spriingboot.web.springbootfirstwebapplication.Controller;

import com.in28minutes.spriingboot.web.springbootfirstwebapplication.Service.ToDoService;
import com.in28minutes.spriingboot.web.springbootfirstwebapplication.Service.TodoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")

public class UpdateToDoController {

    @Autowired
    ToDoService toDoService;

    @RequestMapping(value = "/update", method = RequestMethod.GET)

   public String updateGetToDo(ModelMap modelMap, @RequestParam int id){

        TodoUser todoUser = toDoService.toDoForUser(id);
        modelMap.put("toDo", todoUser.getToDoName());
        modelMap.put("id", id);
        ///System.out.println("--------------------------------------Id " +id);
        return"update";
    }

  /* public String updateGetToDo(ModelMap modelMap, @RequestParam int id){

        TodoUser todoUser = toDoService.toDoForUser(id);
        modelMap.put("toDo", todoUser);

        return"update";
    }
*/

    @RequestMapping(value = "/update", method = RequestMethod.POST)

    public String updateSetToDo(ModelMap modelMap, @RequestParam String toDo, @RequestParam int id) {

        toDoService.updatetoDoForUser(id,toDo);
        return"redirect:/todo";
    }


}



