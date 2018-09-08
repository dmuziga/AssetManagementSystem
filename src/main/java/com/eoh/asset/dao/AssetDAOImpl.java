package com.eoh.asset.dao;

import com.eoh.asset.entity.Asset;
import com.eoh.asset.entity.AssetCategory;
import com.eoh.asset.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Entity;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@EnableTransactionManagement
public class AssetDAOImpl implements AssetDAO{

    //get the current session factory

    @Autowired
    private SessionFactory  sessionFactory;



    @Override
    public void saveAsset(Asset asset) {

        //get current session

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(asset);

    }

    @Override
    public List<Asset> listAssets() {
        // 1. get the current Session

        Session currentSession = sessionFactory.getCurrentSession();

        //2. write the Query to get retrieve all the Asset in the DB

        org.hibernate.query.Query<Asset> theQuery = currentSession.
                createQuery("FROM Asset",Asset.class);

        //3. Get the result

        List<Asset> listOfAssets= theQuery.getResultList();



        //4 return the List of Asset

        return listOfAssets;
    }


    //create the method to retrieve the employee

    private Employee getAssetOwner(int employeeId){


        //1. get the current sesssion

        Session currentSession = sessionFactory.getCurrentSession();

        //2. retrieve the employee by using the employee id

        Employee theEmployee = currentSession.get(Employee.class,employeeId);
        //3. return the employee

        return theEmployee;

    }


    //create the method to retrieve the Asset Category

    private AssetCategory getAssetCategory(int categoryId){

        //1. get the current session

        Session currentSession = sessionFactory.getCurrentSession();

        //retrieve the Asset Category

        AssetCategory theAsset = currentSession.get(AssetCategory.class,categoryId);


        //return the Asset

        return theAsset;

    }

    @Override
    public Asset getAsset(int Assetid) {

        //1.get the Current connection

        Session currentSession = sessionFactory.getCurrentSession();

        //2 query the Asset Form and return the asset based on the AssetID

        Asset theAsset = currentSession.get(Asset.class,Assetid);

        //return the Asset ID

        return theAsset;
    }

    @Override
    public void deleteAsset(int assetid) {

        //get the current Sesstion

        Session currentSession = sessionFactory.getCurrentSession();

        //Write and execute the query to delete the Asset

        Query theQuery = currentSession.createQuery("delete from Asset where assetId =:id");

        theQuery.setParameter("id",assetid);


        theQuery.executeUpdate();

    }
}
