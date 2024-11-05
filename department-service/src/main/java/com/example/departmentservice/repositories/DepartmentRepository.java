package com.example.departmentservice.repositories;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.example.departmentservice.models.Department;

@Repository
public class DepartmentRepository {

    private List<Department> departments = new ArrayList<>();

    public Department addDepartment(Department department){
        departments.add(department);
        return department;
    }

    public Department findById(Long id){
        return departments.stream()
                .filter(department -> department.getId().equals(id))
                .findFirst().orElseThrow();
    }

    public List<Department> findAll(){
        return departments;
    }
}
