package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> showAll();

    void delete(int theId);

    void save(Employee theEmployee);

    Employee findById(int theId);

    List findBymail(String email);
}
