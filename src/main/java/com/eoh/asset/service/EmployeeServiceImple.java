package com.eoh.asset.service;

import com.eoh.asset.dao.EmployeeDAO;
import com.eoh.asset.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImple implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<Employee> getEmployees() {
        return employeeDAO.getEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee theEmployee) {
         employeeDAO.saveEmployee(theEmployee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int theId) {
        return  employeeDAO.getEmployee(theId);
    }

    @Override
    @Transactional
    public void deleteEmployee(int theId) {

        employeeDAO.deleteEmployee(theId);
    }

    @Override
    @Transactional
    public Employee findUserByEmail(String employeeEmail) {
        return employeeDAO.findUserByEmail(employeeEmail);
    }
}
