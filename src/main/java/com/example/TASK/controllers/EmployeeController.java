package com.example.TASK.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TASK.model.Employee;
import com.example.TASK.services.EmpService;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    EmpService empService;

    @GetMapping("/displayAll")
    public ResponseEntity<?> getAllUser() {

        return empService.getAllEmployee();
    }

    
    @GetMapping("/display/{empId}")
    public ResponseEntity<?> getEmpByEmpId(@PathVariable Integer empId) {
    return empService.getEmpByEmpId(empId);
}
    
    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {

        return empService.insertEmpData(employee);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {

        return empService.updateEmpData(employee);
    }

   
    }

