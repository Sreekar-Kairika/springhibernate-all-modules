package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJPAImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
    @Override
    public List<Employee> findAll() {
        //create a query
        Query theQuery = entityManager.createQuery("from Employee");
        //execute a query & get result list
        List<Employee> employees = theQuery.getResultList();
        //return the result

        return employees;
    }

    @Override
    public Employee findById(int theId) {

        //get employee
        Employee theEmployee = entityManager.find(Employee.class,theId);
        // return employee
        return  theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {
        //save or update employee
        Employee dbEmployee = entityManager.merge(theEmployee);

        //update with id from db
        theEmployee.setId(dbEmployee.getId());
    }

    @Override
    public void deleteById(int theId) {

        Query theQuery = entityManager.createQuery("delete from Employee where id:=employeeId");

        theQuery.setParameter("employeeId",theId);

        theQuery.executeUpdate();
    }
}
