package com.example.employeeservice.controllers;

import java.util.*;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeservice.models.Employee;
import com.example.employeeservice.repositories.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/add")
    public Employee add(@RequestBody Employee employee){
        LOGGER.info("inside adding employees {}", employee);
        return employeeRepository.addEmployee(employee);
    }

    @GetMapping("/all")
    public List<Employee> findAll(){
        LOGGER.info("Getting all the employees");
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id){
        LOGGER.info("getting a employee by id={}", id);
        return employeeRepository.findById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId){
        LOGGER.info("Employee find: departmentId={}", departmentId);
        return employeeRepository.findByDepartment(departmentId);
    }
    
}
