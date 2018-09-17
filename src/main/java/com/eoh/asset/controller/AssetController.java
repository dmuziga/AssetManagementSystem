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
import org.springframework.web.bind.annotation.*;
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

        logger.info(employees.toString());


        return modelAndView;
    }


    @PostMapping("/processingAssetForm")
    public String processingAssetFrom(
            @Valid @ModelAttribute ("newAsset")Asset theAsset,
            BindingResult bindingResult,
            Model theModel){


        // retrieve the Manufacture

        Employee newAssetEmployee = theAsset.getEmployee();

        int assetFount = theAsset.getAssetId();

        // display the logger
        logger.info("the new Manufacture name is " +  assetFount);
        logger.info("the new Manufacture name is " +  newAssetEmployee.getFirstName());


        //validation of the Asset form

        if(bindingResult.hasErrors() || newAssetEmployee.getFirstName()==null || theAsset.getAssetcategory() ==null){


            theModel.addAttribute("assetRegistrationError", "Field Cannot be empty");
            //get  the list of employee
            List<Employee> employees = employeeService.getEmployees();

            //get the Category Asset
            List<AssetCategory> assetCategories = assetCategoryService.assetCategries();

            //reload the employee list and asset Category
            theModel.addAttribute("employeeList",employees);
            theModel.addAttribute("assetCategoryList",assetCategories);

            theModel.addAttribute("newAsset", new Asset());
            return "showAssetForm";
        }

        // if not empty please save the new Asset

        assetService.saveAsset(theAsset);

        return "redirect:/homePage";

    }

    @GetMapping("/showAssetForUpdate")
    public String showAssetForUpdate(@RequestParam("assetId")int theAssetId,
                                     Model theModel){

        //get the asset using the AssetId

        Asset theUpdatedAsset = assetService.getAsset(theAssetId);

        //get  the list of employee
        List<Employee> employees = employeeService.getEmployees();

        //get the Category Asset
        List<AssetCategory> assetCategories = assetCategoryService.assetCategries();

        //reload the employee list and asset Category
        theModel.addAttribute("employeeList",employees);
        theModel.addAttribute("assetCategoryList",assetCategories);



        // add the asset to the Model

        theModel.addAttribute("newAsset",theUpdatedAsset);

        return "showAssetForm";
    }

    @GetMapping("/deleteAsset")
    public String deleteAsset(@RequestParam("assetId")int theAssetId){

       //pass the Asset Id into the Service and delete the Asset

        assetService.deleteAsset(theAssetId);


        return "redirect:/homePage";
    }

}
