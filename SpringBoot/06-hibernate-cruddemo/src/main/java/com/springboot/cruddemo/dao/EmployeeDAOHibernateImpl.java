package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{

    //field for entity manager
    private EntityManager entityManager;

    //cosntructor Injection
    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }


    @Override
    public List<Employee> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);
        Query<Employee> theQuery = currentSession.createQuery("from Employee",Employee.class);
        List<Employee> employees = theQuery.getResultList();
        return employees;
    }
    @Override
    public Employee findById(int theId) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // get the employee
        Employee theEmployee = currentSession.get(Employee.class, theId);

        // return the employee
        return theEmployee;
    }



    public void save(Employee theEmployee) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // save employee
        currentSession.saveOrUpdate(theEmployee);
    }



    public void deleteById(int theId) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
        Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");

        theQuery.setParameter("employeeId", theId);

        theQuery.executeUpdate();
    }

}
