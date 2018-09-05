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


    // this method return the number of employee in the database


}
