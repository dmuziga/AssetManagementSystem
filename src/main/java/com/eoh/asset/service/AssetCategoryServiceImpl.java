package com.eoh.asset.service;

import com.eoh.asset.dao.AssetCategoryDAO;
import com.eoh.asset.entity.AssetCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AssetCategoryServiceImpl  implements AssetCategoryService{

    @Autowired
    private AssetCategoryDAO assetCategoryDAO;

    @Override
    @Transactional
    public List<AssetCategory> assetCategries() {
        return assetCategoryDAO.getAssetCategories();
    }

    @Override
    @Transactional
    public AssetCategory getAssetCategory(int theAssetId) {
        return assetCategoryDAO.getAssetCategory(theAssetId);
    }
}
