package com.example.demo.controller;

import com.example.demo.model.LoginModel;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class LoginController {


    @Autowired
    LoginService loginService;

    @PostMapping("login")
    public String addLogin(@RequestBody LoginModel loginModel) {
        return loginService.addLogin(loginModel);
    }

    @GetMapping("login/{id}")
    public LoginModel getLogin(@PathVariable Long id) {
        return loginService.getLogin(id);
    }
}
