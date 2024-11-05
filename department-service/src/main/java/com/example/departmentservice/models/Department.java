package com.example.departmentservice.models;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Department {

    private Long id;

    private String name;

    private List<Employee> employees = new ArrayList<>();
}
