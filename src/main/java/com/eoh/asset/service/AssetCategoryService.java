package com.eoh.asset.service;

import com.eoh.asset.entity.AssetCategory;

import java.util.List;

public interface AssetCategoryService {

    public List<AssetCategory> assetCategries();
    public AssetCategory getAssetCategory(int theAssetId);
}
