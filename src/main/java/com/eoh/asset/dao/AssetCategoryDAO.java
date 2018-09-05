package com.eoh.asset.dao;

import com.eoh.asset.entity.AssetCategory;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AssetCategoryDAO {

    public List<AssetCategory> getAssetCategories();
    public AssetCategory getAssetCategory(int assetcategoryId);


}
