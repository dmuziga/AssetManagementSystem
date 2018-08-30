package com.eoh.asset.controller;

import com.eoh.asset.dao.EmployeeDAO;
import com.eoh.asset.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/asset")
public class AssetController {

     // create a controller to show the form

    @Autowired
    private EmployeeDAO employeeDAO;

    @GetMapping("/showAssetForm")
    public String showAssetForm(Model theModel){

        List<Employee> employees = employeeDAO.getEmployees();

        System.out.println(employees);


        theModel.addAttribute("employeesList", employees);
        return "testEmployee";
    }


    /*@ModelAttribute("employeeList")
    public Collection listEmployee(){


        return employeeDAO.getEmployees();
    }
*/





}
