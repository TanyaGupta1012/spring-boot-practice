package com.luv2code.springboot.crudedemo.rest;

import com.luv2code.springboot.crudedemo.dao.EmployeeDAO;
import com.luv2code.springboot.crudedemo.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    //using constructor injection
    private EmployeeDAO employeeDAO;

    public EmployeeRestController(EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }

    //expose "/employee" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }

}
