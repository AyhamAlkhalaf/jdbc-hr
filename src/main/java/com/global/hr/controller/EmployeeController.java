package com.global.hr.controller;


import com.global.hr.model.Employee;
import com.global.hr.repository.EmployeeReps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeReps employeeReps;


    @GetMapping("/count")
    public  int countEmployees(){

        return  employeeReps.count();

    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id) {

        return employeeReps.findById(id);
    }

    @GetMapping("")
    public List<Employee> findAll() {

        return employeeReps.findAll();
    }


    //	 setter injection
    @Autowired
    @Qualifier("employeeJDBCRepo")
    public EmployeeReps getEmployeeReps() {
        return employeeReps;
    }



}
