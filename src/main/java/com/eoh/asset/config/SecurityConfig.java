package com.eoh.asset.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;
import java.util.logging.Logger;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource securityDataSource;

    private Logger logger = Logger.getLogger(getClass().getName());


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

         // let connect now to our Database

        logger.info("starting Connection =================");

       //Customize the login
        auth.jdbcAuthentication()
                .dataSource(securityDataSource)
                .usersByUsernameQuery(
                        "SELECT email, password, IF(Enable=1, 'true', 'false') as enabled FROM employee WHERE email = ?")
                .authoritiesByUsernameQuery(
                        "SELECT employee.email, employee_role.RoleDesc as authorities " +
                                "FROM employee, employee_role " +
                                "WHERE employee.email = ? AND employee.Employee_RoleID = employee_role.RoleID");


    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/asset/listAsset").hasRole("ADMIN")

                   // this allow authentication before the user browse to any path on the system
                .antMatchers("/homepage").hasAnyRole("ADMIN","USER")
                .antMatchers("/employee/**").permitAll()
                .antMatchers("/resources/**").permitAll()
                .and()
                .formLogin()
                .loginPage("/LoginForm")
                .loginProcessingUrl("/authenticateTheUser")
                .defaultSuccessUrl("/homePage")
                .permitAll()
                .and()
                .logout().permitAll();


    }



}
