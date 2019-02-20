package com.luv2code.springboot.cruddemo.DAO;

import com.luv2code.springboot.cruddemo.Entity.Employee;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeRepo implements IEmployee {
private EntityManager _EntityManager;
@Autowired
public  EmployeeRepo(EntityManager entityManager){
    _EntityManager = entityManager;
}
    @Override
    public List<Employee> getAllEmployees() {
        Session currentSession = _EntityManager.unwrap(Session.class);
       Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
       List<Employee> employeeList = query.getResultList();
       return  employeeList;
    }

    @Override
    public Employee getEmployee(int id) {
        Session currentSession = _EntityManager.unwrap(Session.class);
        Employee employee = currentSession.get(Employee.class, id);
        return employee;
    }

    @Override
    public void createEmployee(Employee employeeModel) {
        Session currentSession = _EntityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(employeeModel);
    }

    @Override
    public void deleteEmployee(int id) {
        Session currentSession = _EntityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("delete from Employee where Id =:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

}
