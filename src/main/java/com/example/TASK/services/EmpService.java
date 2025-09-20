package com.example.TASK.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.TASK.model.Employee;
import com.example.TASK.repositories.EmpRepository;
import java.util.Optional;


@Service
public class EmpService {

    @Autowired
    EmpRepository empRepo;

    // Get all employee
    public ResponseEntity<?> getAllEmployee() {
        return ResponseEntity.ok(empRepo.findAll());
    }

    // Get employee by empId
    public ResponseEntity<?> getEmpByEmpId(Integer empId) {
    
    // search for employee with matching empId
    Optional<Employee> employee = empRepo.findAll()
                                         .stream()
                                         .filter(e -> e.getEmpId() != null && e.getEmpId().equals(empId))
                                         .findFirst();

    if (employee.isPresent()) {
        return ResponseEntity.ok(employee.get());
    } else {
        return ResponseEntity.status(404).body("Employee with empId " + empId + " not found");
    }
}
    // Add data
    public ResponseEntity<?> insertEmpData(Employee employee) {
        empRepo.save(employee);
        return ResponseEntity.ok(employee);
    }

    @Autowired
    EmpRepository EmpRepository;
    // update data 
    public ResponseEntity<?> updateEmpData(Employee employee) {
        // Find employee by empId
        Optional<Employee> existing = EmpRepository.findAll()
                .stream()
                .filter(e -> e.getEmpId() != null && e.getEmpId().equals(employee.getEmpId()))
                .findFirst();

        if (existing.isPresent()) {
            // Set the ID of the existing employee to ensure update
            employee.setId(existing.get().getId());
            EmpRepository.save(employee); 
            return ResponseEntity.ok(employee); 
        } else {
            return ResponseEntity.status(404)
                    .body("Employee with empId " + employee.getEmpId() + " not found");
        }
    }}


   