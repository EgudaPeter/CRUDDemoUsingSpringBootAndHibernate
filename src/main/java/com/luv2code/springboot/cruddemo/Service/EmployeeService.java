package com.luv2code.springboot.cruddemo.Service;

import com.luv2code.springboot.cruddemo.DAO.IEmployee;
import com.luv2code.springboot.cruddemo.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    private IEmployee _IEmployee;

    @Autowired
    public EmployeeService(IEmployee employee) {
        _IEmployee = employee;
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return _IEmployee.getAllEmployees();
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return _IEmployee.getEmployee(id);
    }

    @Override
    @Transactional
    public void createEmployee(Employee employeeModel) {
        _IEmployee.createEmployee(employeeModel);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        _IEmployee.deleteEmployee(id);
    }
}
