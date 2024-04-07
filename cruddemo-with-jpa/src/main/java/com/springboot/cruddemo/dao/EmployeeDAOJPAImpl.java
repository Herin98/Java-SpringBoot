package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOJPAImpl implements  EmployeeDAO{
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Employee> showAll() {
        List<Employee> employeeList=entityManager.createQuery("from Employee",Employee.class).getResultList();
        return employeeList;
    }

    @Override
    public void delete(int theId) {
        Employee tempEmployee=entityManager.find(Employee.class,theId);
        entityManager.remove(tempEmployee);

    }

    @Override
    public void save(Employee theEmployee) {
       Employee employee= entityManager.merge(theEmployee);
       theEmployee.setId(employee.getId());


    }

    @Override
    @Transactional
    public Employee findById(int theId) {
        return entityManager.find(Employee.class,theId);
    }

    @Override
    @Transactional
    public List findBymail(String email) {
        System.out.println("In DAO: " + email);
        /*return entityManager.createQuery(
                        "SELECT e FROM employee e WHERE e.email LIKE :email")
                .setParameter("email", email)
                .getResultList();*/

        List<Employee> employees =  entityManager.createQuery("SELECT c FROM employee c WHERE c.email LIKE ?1")
                .setParameter(1, email)
                .getResultList();
        System.out.println(employees);
        return employees;
    }
}
