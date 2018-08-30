package com.eoh.asset.dao;

import com.eoh.asset.entity.Asset;
import com.eoh.asset.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AssetDAO {

    public void saveAsset(Asset asset);

}
