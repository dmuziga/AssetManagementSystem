package com.eoh.asset.controller;

import com.eoh.asset.entity.Employee;
import com.eoh.asset.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.logging.Logger;

@Controller
@RequestMapping("/employee")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


   private Logger logger = Logger.getLogger(getClass().getName());

    @GetMapping("/registerEmployee")
    public String registerEmployee(Model theModel){

        theModel.addAttribute("emp",new Employee());

        return "employeeRegistration-form";
    }

    @GetMapping("/register")
    public String showForm(){

        return "register-form";
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm (
            @Valid @ModelAttribute ("emp")Employee theEmployee,
            BindingResult theBindingResult,
            Model theModel){

        // retrieve the Employee Name

        String employeeEmail = theEmployee.getEmail();
        // for  Info purposes : Display the USername

        logger.info(" The user Logging is " +  employeeEmail);

        // Validation of the data

        if (theBindingResult.hasErrors()){

            theModel.addAttribute("emp", new Employee());
            theModel.addAttribute("registrationError", "User name/password can not be empty");


            logger.warning("Please fill in the required info");


            return "register-form";

        }

        //check the database if the user already exist


        Employee employeeExist = employeeService.findUserByEmail(employeeEmail);

        if (employeeExist !=null){

            theModel.addAttribute("emp", new Employee());
            theModel.addAttribute("registrationError", "Email Already exist");

            logger.warning("Email Already exist");

            return "employeeRegistration-form";
        }


        // for now let not encrypt the password

        String passwordEmp = passwordEncoder.encode(theEmployee.getPassword());

        passwordEmp = "{bcrypt}" + passwordEmp;

        theEmployee.setPassword(passwordEmp);

        employeeService.saveEmployee(theEmployee);

        logger.info("Successfully created user: " + employeeEmail);

        // insert


        return "registration-confirmation";
    }




}
