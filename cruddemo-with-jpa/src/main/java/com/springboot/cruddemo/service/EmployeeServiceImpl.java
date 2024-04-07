package com.springboot.cruddemo.service;

import com.springboot.cruddemo.dao.EmployeeDAO;
import com.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    @Qualifier("employeeDAOJPAImpl")
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<Employee> showAll() {
        return employeeDAO.showAll();

    }

    @Override
    @Transactional
    public Employee findByID(int theId) {
        return employeeDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(Employee theEmployee) {
        employeeDAO.save(theEmployee);

    }

    @Override
    @Transactional
    public void delete(int theId) {
        employeeDAO.delete(theId);

    }

    public List findBymail(String email) { return employeeDAO.findBymail(email); }
}
