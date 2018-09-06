package com.eoh.asset.service;

import com.eoh.asset.dao.AssetDAO;
import com.eoh.asset.entity.Asset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AssetServiceImpl implements AssetService {

    //inject the AssetDAO

    @Autowired
    private AssetDAO assetDao;

    @Override
    @Transactional
    public List<Asset> listAssets() {
        return assetDao.listAssets();
    }

    @Override
    @Transactional
    public void saveAsset(Asset theAsset) {


        assetDao.saveAsset(theAsset);
    }


    @Override
    public Asset getAsset(int id) {
        return assetDao.getAsset(id);
    }
}
