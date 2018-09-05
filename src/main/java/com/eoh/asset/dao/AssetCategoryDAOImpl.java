package com.eoh.asset.dao;

import com.eoh.asset.entity.AssetCategory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.management.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@EnableTransactionManagement
public class AssetCategoryDAOImpl implements AssetCategoryDAO {

    //1. get the current Session

   @Autowired
   private SessionFactory sessionFactory;


    @Override
    public List<AssetCategory> getAssetCategories() {

        //1.get the Session

        Session currentSession= sessionFactory.getCurrentSession();

        //create the Query to retrieve the asset Category

        String AssetCategoryQuery = "FROM AssetCategory";

        // execute the query to get the asset Category

        org.hibernate.query.Query<AssetCategory> assetQuery =
                currentSession.createQuery(AssetCategoryQuery,AssetCategory.class);

        List<AssetCategory> assetsTypes = assetQuery.getResultList();
        // return the List of the category

        return assetsTypes;
    }

    @Override
    public AssetCategory getAssetCategory(int assetcategoryId) {

        Session currentSession = sessionFactory.getCurrentSession();

        AssetCategory assetCategory = currentSession.get(AssetCategory.class,assetcategoryId);

        return assetCategory;
    }
}
