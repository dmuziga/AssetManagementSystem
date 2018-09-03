package com.eoh.asset.controller;


import com.eoh.asset.entity.Employee;
import com.eoh.asset.entity.RegisterAsset;
import com.eoh.asset.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/asset")
public class AssetController {

     // create a controller to show the form

   @Autowired
    private EmployeeService employeeService;
    @GetMapping("/showAssetForm")
    public String showAssetForm(ModelMap theModel){

        List<Employee> employees = employeeService.getEmployees();

        System.out.println(employees);


        theModel.addAttribute("newAsset", new RegisterAsset());


        //import the asset Model

        theModel.addAttribute("employeeList", employees);

        return "showAssetForm";
    }










}
