package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.*;
import com.example.demo.repository.*;

import jakarta.transaction.Transactional;

@Service
public class Studentservice {

     @Autowired
    private Studentrepository studentrepository;
    
    public void addemployee(Studentmodel studentmodel) {
        studentrepository.save(studentmodel);

    }

    public List<Studentmodel> getStudent() {
        return studentrepository.findAll();
    }

    public String editStudent(int employeeid, Studentmodel updatedStudent) {
        Optional<Studentmodel> stu = studentrepository.findByEmployeeid(employeeid);
        if (stu.isPresent()) {
            Studentmodel student = stu.get();

            student.setEmployeeid(updatedStudent.getEmployeeid());
            student.setEmployeename(updatedStudent.getEmployeename());
            student.setInternshipname(updatedStudent.getInternshipname());
            studentrepository.save(student);
            return "Employee details edited";
        }
        return "Employee not found";
    }

     
    @Transactional
    public String deletEmployee(Integer employeeId) {
        Optional<Studentmodel> studentmodel = studentrepository.findByEmployeeid(employeeId);
        if (studentmodel.isPresent()) {
            studentrepository.deleteByEmployeeid(employeeId);
            return "Employee details deleted";
        }
        return "Employee not Found";
    }

}
