package com.eoh.asset.service;

import com.eoh.asset.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getEmployees();
    public void saveEmployee (Employee theEmployee);
    public Employee getEmployee(int theId);
    public void deleteEmployee(int theId);
    public Employee findUserByEmail(String employeeEmail);


}
