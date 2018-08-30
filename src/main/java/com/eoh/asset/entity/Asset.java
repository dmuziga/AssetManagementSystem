package com.eoh.asset.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "asset")
public class Asset {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AssetId")
    private int assetId;

    @Column(name = "Manufacture")
    private String manufacture;

    @Column(name ="Model")
    private String model;

    @Column(name="SerialNumber")
    private String serialNumber;

    @Column(name="AcquiredDate")
    private Date acquiredDate;


    @Column(name="PurchasePrice")
    private double purchasePrice;

    @Column(name="Description")
    private String description;

    @Column (name ="Comments")
    private String comments;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name="Owner")
    private Employee employee;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name="AssetCategory")
    private AssetCategory assetcategory;


    public Asset() {
    }

    public int getAssetId() {
        return assetId;
    }

    public void setAssetId(int assetId) {
        this.assetId = assetId;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Date getAcquiredDate() {
        return acquiredDate;
    }

    public void setAcquiredDate(Date acquiredDate) {
        this.acquiredDate = acquiredDate;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public AssetCategory getAssetcategory() {
        return assetcategory;
    }

    public void setAssetcategory(AssetCategory assetcategory) {
        this.assetcategory = assetcategory;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "assetId=" + assetId +
                ", manufacture='" + manufacture + '\'' +
                ", model='" + model + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", acquiredDate=" + acquiredDate +
                ", purchasePrice=" + purchasePrice +
                ", description='" + description + '\'' +
                ", comments='" + comments + '\'' +
                ", employee=" + employee +
                ", assetcategory=" + assetcategory +
                '}';
    }
}
