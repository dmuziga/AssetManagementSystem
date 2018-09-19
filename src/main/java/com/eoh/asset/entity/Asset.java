package com.eoh.asset.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "asset")
public class Asset {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AssetId")
    private int assetId;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    @Column(name = "Manufacture")
    private String manufacture;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    @Column(name ="Model")
    private String model;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    @Column(name="SerialNumber")
    private String serialNumber;

    @NotNull(message = "is required")
    @Column(name="AcquiredDate")
    private Date acquiredDate;

    @NotNull(message = "is required")
    @Column(name="PurchasePrice")
    private double purchasePrice;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    @Column(name="Description")
    private String description;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    @Column (name ="Comments")
    private String comments;

    @NotNull(message = "is required")
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
