package com.luv2code.springboot.crudedemo.dao;

import com.luv2code.springboot.crudedemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deletedById(int theId);
}
