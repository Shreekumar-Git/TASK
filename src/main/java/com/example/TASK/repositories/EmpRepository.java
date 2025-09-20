package com.example.TASK.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.TASK.model.Employee;


public interface EmpRepository extends MongoRepository<Employee, String> {

    
}
