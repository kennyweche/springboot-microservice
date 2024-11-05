package com.example.departmentservice.controllers;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.departmentservice.client.EmployeeClient;
import com.example.departmentservice.models.Department;
import com.example.departmentservice.repositories.DepartmentRepository;


@RestController
@RequestMapping("/department")
public class DepartmentContoller {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(DepartmentContoller.class);

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeClient employeeClient;

    @PostMapping("/add")
    public Department add(@RequestBody Department department){
        LOGGER.info("inside adding department {}", department);
        return departmentRepository.addDepartment(department);
    }

    @GetMapping("/all")
    public List<Department> findAll(){
        LOGGER.info("Getting all the departments");
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id){
        LOGGER.info("getting a department by id={}", id);
        return departmentRepository.findById(id);
    }

    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees(){
        LOGGER.info("Get departments with employees from the employee-service");
        List<Department> departments = departmentRepository.findAll();
        departments.forEach(department -> department.setEmployees(employeeClient.findByDepartment(department.getId())));

        return departments;
    }
    
}
