package com.eoh.asset.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="employee_role")
public class Employee_role {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="RoleID")
    private int RoleID;


    @Column(name="RoleDesc")
    private String RoleDesc;


    public Employee_role() {
    }

    public int getRoleID() {
        return RoleID;
    }

    public void setRoleID(int roleID) {
        RoleID = roleID;
    }

    public String getRoleDesc() {
        return RoleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        RoleDesc = roleDesc;
    }

    @Override
    public String toString() {
        return "Employee_role{" +
                "RoleID=" + RoleID +
                ", RoleDesc='" + RoleDesc + '\'' +
                '}';
    }
}
