package com.eoh.asset.entity;



import org.springframework.stereotype.Component;

@Component
public class RegisterAsset {

    private Employee employee;
    private Asset asset;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }



}
