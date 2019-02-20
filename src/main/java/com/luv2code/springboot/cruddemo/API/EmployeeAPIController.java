package com.luv2code.springboot.cruddemo.API;

import com.luv2code.springboot.cruddemo.Entity.Employee;
import com.luv2code.springboot.cruddemo.Service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeAPIController {
    private IEmployeeService _IEmployeeService;

    @Autowired
    public EmployeeAPIController(IEmployeeService employeeService) {
        _IEmployeeService = employeeService;
    }

    @GetMapping("/getemployees")
    public List<Employee> GetEmployees() {
        return _IEmployeeService.getAllEmployees();
    }

    @GetMapping("/getemployee/{employeeId}")
    public Employee GetEmployee(@PathVariable int employeeId) {
        Employee employee = _IEmployeeService.getEmployee(employeeId);
        if (employee != null) {
            return employee;
        }
        throw new RuntimeException("Employee of id" + employeeId + " is not found");
    }

    @PostMapping("/createemployee")
    public Employee CreateEmployee(@RequestBody Employee employeeModel) {
        if (employeeModel.getId() > 0) {
            employeeModel.setId(0);
        }
        _IEmployeeService.createEmployee(employeeModel);
        return employeeModel;
    }

    @PutMapping("/updateemployee")
    public Employee Updatemployee(@RequestBody Employee employeeModel) {
        _IEmployeeService.createEmployee(employeeModel);
        return employeeModel;
    }

    @DeleteMapping("/deleteemployee/{employeeid}")
    public void DeleteEmployee(@PathVariable int employeeid) {
        Employee employee = _IEmployeeService.getEmployee(employeeid);
        if (employee != null) {
            _IEmployeeService.deleteEmployee(employeeid);
        }
        throw new RuntimeException("Employee does not exist with Id " + employeeid);
    }
}
