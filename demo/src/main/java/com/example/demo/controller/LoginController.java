package com.example.demo.controller;

import com.example.demo.model.LoginModel;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("login")
    public LoginModel addLogin(@RequestBody LoginModel loginModel) {
        return loginService.addLogin(loginModel);
    }

    @GetMapping("login/{id}")
    public LoginModel getLogin(@PathVariable Long id) {
        return loginService.getLogin(id);
    }
}
