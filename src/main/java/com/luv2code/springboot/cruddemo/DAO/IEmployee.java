package com.luv2code.springboot.cruddemo.DAO;

import com.luv2code.springboot.cruddemo.Entity.Employee;

import java.util.List;

public interface IEmployee {
    List<Employee> getAllEmployees();
    Employee getEmployee(int id);
    void createEmployee(Employee employeeModel);
    void deleteEmployee(int id);
}
