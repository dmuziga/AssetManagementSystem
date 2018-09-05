package com.eoh.asset.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;

    @NotNull(message="is required")
    @Size(min=1, message = "is required")
    @Column(name="Firstname")
    private String firstName;
    @NotNull(message="is required")
    @Size(min=1, message = "is required")
    @Column(name="Lastname")
    private String lastName;

    @NotNull(message="is required")
    @Size(min=1, message = "is required")
    @Column(name="PhoneNumber")
    private String phoneNumber;

    @NotNull(message="is required")
    @Size(min=1, message = "is required")
    @Column(name="Email")
    private String email;


    @NotNull(message="is required")
    @Size(min=1, message = "is required")
    @Column(name="PASSWORD")
    private String password;


    @Column(name="Enable")
    private int enable;

    @OneToOne()
    @JoinColumn(name="Employee_RoleID")
    private Employee_role employeeRole;

    //one employee may have many Asset
/*

  @OneToMany(mappedBy = "employee",
                cascade = {CascadeType.PERSIST,CascadeType.MERGE,
                           CascadeType.DETACH,CascadeType.REFRESH})
  private Set<Asset> assetSet;
*/


    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public Employee_role getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(Employee_role employeeRole) {
        this.employeeRole = employeeRole;
    }

/*
    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }
*/

/*
    public Set<Asset> getAssetSet() {
        return assetSet;
    }

    public void setAssetSet(Set<Asset> assetSet) {
        this.assetSet = assetSet;
    }
*/

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                 ", password='" + password + '\'' +
                ", enable=" + enable +
                ", employeeRole=" + employeeRole +
                '}';
    }
}
