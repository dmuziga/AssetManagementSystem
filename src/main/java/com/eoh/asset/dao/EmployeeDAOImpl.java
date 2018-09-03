package com.eoh.asset.dao;

import com.eoh.asset.entity.Employee;
import com.eoh.asset.entity.Employee_role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.management.Query;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Repository
@Transactional
@EnableTransactionManagement
public class EmployeeDAOImpl implements EmployeeDAO {

    //Inject  the database session factory

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void saveEmployee(Employee theEmployee) {

        //get the current session

        Session currentSession = sessionFactory.getCurrentSession();
            // set the User Role before saving the employee

        theEmployee.setEmployeeRole(getEmployeeRole(1));
        theEmployee.setEnable(1);

        //create the query to save a new Employee

        System.err.println(theEmployee);
        currentSession.saveOrUpdate(theEmployee);

    }

    @Override
    public Employee getEmployee(int theId) {
        return null;
    }

    @Override
    public void deleteEmployee(int theId) {

    }


   /* @Override
    public Employee findUserByUsername(String employeeUsername) {


        Session currentSession = sessionFactory.getCurrentSession();

       String hql = "From Employee where username=:username";

       org.hibernate.query.Query query = currentSession.createQuery(hql);

       query.setParameter("username",employeeUsername);



        return (Employee)query.uniqueResult();
    }*/

    @Override
   public Employee findUserByEmail(String employeeEmail) {


       Session currentSession = sessionFactory.getCurrentSession();

       String hql = "From Employee where email=:email";


       org.hibernate.query.Query query = currentSession.createQuery(hql);

/*      Employee temp =currentSession.get(Employee.class,1);*/

        query.setParameter("email",employeeEmail);



      return (Employee)query.uniqueResult();


   }



    //get the user Role
    @Override
    public Employee_role getEmployeeRole(int userRoleID) {

        Session currentSession = sessionFactory.getCurrentSession();
        Employee_role userRole = currentSession.get(Employee_role.class,userRoleID);
        return userRole;
    }


    @Override
    public List<Employee> getEmployees() {
        //1. get the current Database session

        Session currentSession= sessionFactory.getCurrentSession();

        // 2. Query the DB  to return Employees

        org.hibernate.query.Query<Employee> theQuery =
                currentSession.createQuery( "FROM Employee",Employee.class);
        //3. Execute the Query

        List<Employee> employees = theQuery.getResultList();


        //return the List of employees
        return employees;
    }
}
