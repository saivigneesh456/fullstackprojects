package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    // private final LoginRepository loginRepository;

    @Autowired
    LoginRepository loginRepository;
    
    @Autowired
    SignupRepository signupRepository;
    // public LoginService(LoginRepository loginRepository) {
    //     this.loginRepository = loginRepository;
    // }

    public String addLogin(LoginModel loginModel) {
      Optional<SignupModel> signupModel = signupRepository.findByEmail(loginModel.getEmail());
      
        if(signupModel.isPresent()){
            if(signupModel.get().getPassword().equals(loginModel.getPassword())){
                 if(signupModel.get().getUserrole().equals("admin")){
                return "admin Logged in";
            } else{
                return "user logged in";
            }
        }else{
            return "Invalid credentials";
        }
        }
        else{
            return "User Not Found";
        }

    }

    public LoginModel getLogin(Long id) {
        return loginRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Login with ID " + id + " not found"));
    }
}
