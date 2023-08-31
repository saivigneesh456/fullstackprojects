package com.example.demo.service;

import com.example.demo.model.LoginModel;
import com.example.demo.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final LoginRepository loginRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public LoginModel addLogin(LoginModel loginModel) {
        return loginRepository.save(loginModel);
    }

    public LoginModel getLogin(Long id) {
        return loginRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Login with ID " + id + " not found"));
    }
}
