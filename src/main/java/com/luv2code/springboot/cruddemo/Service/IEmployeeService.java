package com.luv2code.springboot.cruddemo.Service;

import com.luv2code.springboot.cruddemo.Entity.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployee(int id);
    void createEmployee(Employee employeeModel);
    void deleteEmployee(int id);
}
