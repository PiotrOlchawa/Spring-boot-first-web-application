package com.spriingboot.springbootfirstwebapplication.Controller;

import com.spriingboot.springbootfirstwebapplication.Service.LoginValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@SessionAttributes("name")
@Controller
public class LoginPage {

    @Autowired
    LoginValidator loginValidator;

    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String handleLoginGet() {
        return "loginPage";
    }

    @RequestMapping(value = "/loginPage", method = RequestMethod.POST)
    public String handleLogin(@RequestParam String name, @RequestParam String password, ModelMap modelMap) {

        if (!loginValidator.hardValidate(name, password)) {
            modelMap.put("errorMessage", "Bad login cerdinentals !");
            return "loginPage";
        }
        modelMap.put("name", name);
        modelMap.put("password", password);
        return "welcome";
    }
}
