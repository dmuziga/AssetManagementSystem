package com.eoh.asset.service;

import com.eoh.asset.entity.Asset;

import java.util.List;

public interface AssetService {

    public void saveAsset(Asset theAsset);
    public List<Asset> listAssets();
    public Asset getAsset(int id);
    public void deleteAsset(int id);
}
