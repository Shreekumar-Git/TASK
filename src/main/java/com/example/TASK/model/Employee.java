package com.example.TASK.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Employee")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee {
  @Id
  private String id;

  private Integer EmpId;
  private String EmpName;
  private String EmpEmail;
  private String EmpLocation;

}







  