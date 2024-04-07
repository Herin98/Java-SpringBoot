package com.webapp.springdemo.dao;

import com.webapp.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class CustomerDAOImpl implements  CustomerDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    @Transactional
    public List<Customer> getCustomers() {
        Session session =sessionFactory.getCurrentSession();
        Query<Customer> query=session.createQuery("from Customer order by lastName desc",Customer.class);
        List<Customer> customerList=query.getResultList();
        return customerList;
    }

    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(theCustomer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int theId) {
        Session session=sessionFactory.getCurrentSession();
        Customer theCustomer=session.get(Customer.class,theId);
        return theCustomer;
    }

    @Override
    @Transactional
    public void delete(int id) {
        Session session= sessionFactory.getCurrentSession();
        Customer customer=session.get(Customer.class,id);
        session.delete(customer);
    }
}
