package com.eoh.asset.entity;

import javax.persistence.*;

@Entity
@Table(name="assetcategory")
public class AssetCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID")
    private int assetcategoryid;

    @Column(name="CategoryName")
    private String categoryname;

    public AssetCategory() {
    }

    public int getAssetcategoryid() {
        return assetcategoryid;
    }

    public void setAssetcategoryid(int assetcategoryid) {
        this.assetcategoryid = assetcategoryid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }
}
