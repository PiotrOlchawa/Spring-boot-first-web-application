package com.spriingboot.springbootfirstwebapplication.Service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class LoginValidator {

    public boolean hardValidate(String name, String password) {
        return name.equals("piotr") && password.equals("password");
    }
}
