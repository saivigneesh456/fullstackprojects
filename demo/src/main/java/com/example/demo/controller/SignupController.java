package com.example.demo.controller;

import com.example.demo.model.SignupModel;
import com.example.demo.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class SignupController {

    private final SignupService signupService;

    @Autowired
    public SignupController(SignupService signupService) {
        this.signupService = signupService;
    }

    @PostMapping("signup")
    public SignupModel addSignup(@RequestBody SignupModel signupModel) {
        System.out.println("hi i am signup post");
        return signupService.addSignup(signupModel);
    }

    @GetMapping("signup/{id}")
    public SignupModel getSignup(@PathVariable Long id) {
        return signupService.getSignup(id);
    }
}
