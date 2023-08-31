package com.example.demo.service;

import com.example.demo.model.SignupModel;
import com.example.demo.repository.SignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupService {

    private final SignupRepository signupRepository;

    @Autowired
    public SignupService(SignupRepository signupRepository) {
        this.signupRepository = signupRepository;
    }

    public SignupModel addSignup(SignupModel signupModel) {
        return signupRepository.save(signupModel);
    }

    public SignupModel getSignup(Long id) {
        return signupRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Signup with ID " + id + " not found"));
    }
}
