package com.eoh.asset.dao;

import com.eoh.asset.entity.Employee;
import com.eoh.asset.entity.Employee_role;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> getEmployees();
    public void saveEmployee (Employee theEmployee);
    public Employee getEmployee(int theId);
    public void deleteEmployee(int theId);
    public Employee findUserByEmail(String employeeUsername);
    public Employee_role getEmployeeRole(int userRoleID);

}
