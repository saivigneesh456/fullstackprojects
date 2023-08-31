package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.*;

public interface Studentrepository extends JpaRepository<Studentmodel, Long> {
    
    List<Studentmodel> findAll();
    Optional<Studentmodel> findByEmployeeid (Integer employeeid);
    Integer deleteByEmployeeid(Integer employeeid);

    
}
