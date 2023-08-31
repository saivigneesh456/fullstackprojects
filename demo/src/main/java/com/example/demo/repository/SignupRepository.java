package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.SignupModel;

public interface SignupRepository extends JpaRepository<SignupModel,Long>{
    
}