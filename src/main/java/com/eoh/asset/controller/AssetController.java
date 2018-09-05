package com.eoh.asset.controller;


import com.eoh.asset.entity.Asset;
import com.eoh.asset.entity.AssetCategory;
import com.eoh.asset.entity.Employee;
import com.eoh.asset.entity.RegisterAsset;
import com.eoh.asset.service.AssetCategoryService;
import com.eoh.asset.service.AssetService;
import com.eoh.asset.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.LongFunction;
import java.util.logging.Logger;


@Controller
@RequestMapping("/asset")
public class AssetController {


    private Logger logger = Logger.getLogger(getClass().getName());

     // create a controller to show the form

   @Autowired
    private EmployeeService employeeService;

   @Autowired
    private AssetCategoryService assetCategoryService;

   @Autowired
   private AssetService assetService;


    @GetMapping("/showAssetForm")
    public ModelAndView getAddAsset(){

        // create a model view Object with three parameter View Name , the Model Name and the Object to create Asset
        ModelAndView modelAndView = new ModelAndView("showAssetForm","newAsset",new Asset());

        //get  the list of employee
        List<Employee> employees = employeeService.getEmployees();

        //get the Category Asset
        List<AssetCategory> assetCategories = assetCategoryService.assetCategries();


        modelAndView.addObject("employeeList",employees);
        modelAndView.addObject("assetCategoryList",assetCategories);


        return modelAndView;
    }


    @PostMapping("/processingAssetForm")
    public String processingAssetFrom(
            @Valid @ModelAttribute ("newAsset")Asset theAsset,
            BindingResult bindingResult,
            Model theModel){


        // retrieve the Manufacture

        Employee newAssetEmployee = theAsset.getEmployee();

        // display the logger

        logger.info("the new Manufacture name is " +  newAssetEmployee.getFirstName());


        //validation of the Asset form

        if(bindingResult.hasErrors()){

            theModel.addAttribute("newAsset", new Asset());
            theModel.addAttribute("assetRegistrationError", "Field Cannot be empty");

            return "showAssetForm";
        }

        // if not empty please save the new Asset

        assetService.saveAsset(theAsset);

        return "homePage";

    }










}
