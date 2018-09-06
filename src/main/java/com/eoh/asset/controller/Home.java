package com.eoh.asset.controller;

import com.eoh.asset.entity.Asset;
import com.eoh.asset.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/")
public class Home {

    @Autowired
    private AssetService assetService;

    @GetMapping
    public String LoginForm(){

        return "HomeLogin";
    }

    @GetMapping("/homePage")
    public String homePage(Model theModel){

        List<Asset> assetsList = assetService.listAssets();

        theModel.addAttribute("assets", assetsList);

        return "homePage";
    }

}
