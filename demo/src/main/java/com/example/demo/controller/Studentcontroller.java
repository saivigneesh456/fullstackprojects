package com.example.demo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.*;
import com.example.demo.service.*;

@RestController
@RequestMapping("/")

public class Studentcontroller {

    @Autowired 
    private Studentservice studentservice;

     @PostMapping("addemployees")
    public String saveNewUser(@RequestBody Studentmodel studentmodel) {
            studentservice.addemployee(studentmodel);
        return "employee added";
    }

     @GetMapping("viewemployees")
    public List<Studentmodel> viewStudent() {
        return studentservice.getStudent();
    }

    @PutMapping("editemployee/{employeeid}")
    public String editStudent(@PathVariable("employeeid") Integer employeeid,
            @RequestBody Studentmodel updatedStudent) {
        return studentservice.editStudent(employeeid, updatedStudent);
    }
    @DeleteMapping("deleteEmployee/{employeeid}")
    public String deleteemployee(@PathVariable("employeeid") Integer employeeId) {
        return studentservice.deletEmployee(employeeId);
    }
}
