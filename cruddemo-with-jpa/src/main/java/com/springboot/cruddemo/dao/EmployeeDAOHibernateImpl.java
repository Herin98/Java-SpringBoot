package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{
    private EntityManager entityManager;
    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }
    @Override

    public List<Employee> showAll() {
        Session currentSession=entityManager.unwrap(Session.class);
        Query<Employee> theQuery=currentSession.createQuery("from Employee",Employee.class);
        List<Employee> employeeList=theQuery.getResultList();
        return employeeList;
    }

    @Override
    public void delete(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);


        Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", theId);

        theQuery.executeUpdate();

    }

    @Override
    public void save(Employee theEmployee) {
        Session currentSession=entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theEmployee);

    }

    @Override
    public Employee findById(int theId) {
        Session currentSession=entityManager.unwrap(Session.class);
        Employee employee=currentSession.get(Employee.class,theId);
        return employee;
    }

    @Override
    public List findBymail(String email){
        System.out.println("Inside Hibernate DAO");
        return null;
    }
}
