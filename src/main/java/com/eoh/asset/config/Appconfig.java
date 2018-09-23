package com.eoh.asset.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.core.env.Environment;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan("com.eoh.asset")
@PropertySource({"classpath:security-persistence-mysql.properties"})
public class Appconfig implements WebMvcConfigurer {



     @Autowired
     private Environment env; // the Environment class Help us read the property file

    private Logger logger = Logger.getLogger(getClass().getName());

    @Bean
    public ViewResolver viewResolver(){

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;

    }


    // =====we need to define our security Data source


    @Bean
    public DataSource securityDataSource(){

        //create a connection pool

        ComboPooledDataSource securityDataSource = new ComboPooledDataSource();


        try {
            securityDataSource.setDriverClass(env.getProperty("security.jdbc.driver"));
        } catch (PropertyVetoException exc) {
            throw new RuntimeException(exc);
        }


        logger.info("Jdbc.url ========= " +  env.getProperty("security.jdbc.url"));
        logger.info("Jdbc.user ======== " +  env.getProperty("security.jdbc.user"));


        // Let set my Database connection

        securityDataSource.setJdbcUrl(env.getProperty("security.jdbc.url"));
        securityDataSource.setUser(env.getProperty("security.jdbc.user"));
        securityDataSource.setPassword(env.getProperty("security.jdbc.password"));


        //let set the connection pool

        securityDataSource.setInitialPoolSize(getIntProperty("security.connection.pool.initialPoolSize"));
        securityDataSource.setMinPoolSize(getIntProperty("security.connection.pool.minPoolSize"));
        securityDataSource.setMaxPoolSize(getIntProperty("security.connection.pool.maxPoolSize"));
        securityDataSource.setMaxIdleTime(getIntProperty("security.connection.pool.maxIdleTime"));



        return securityDataSource;


    }

    /*Spring email*/

    @Bean
    public JavaMailSender getJavaMailSender(){

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("dmuziga@gmail.com");
        mailSender.setPassword("mtukstxjimqiwoox");


        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol","smtp");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug","true");

        return mailSender;

    }

    private Properties getHibernateProperties(){


        //set hibernate properties

        Properties props = new Properties();

        props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        props.setProperty("hibernate.showSql", env.getProperty("hibernate.show_sql"));

        return props;

    }





    private int getIntProperty(String property){

        String envProperty = env.getProperty(property);

        int props = Integer.parseInt(envProperty);

        return props;

    }


    @Bean
    public LocalSessionFactoryBean sessionFactoryBean(){

        //create session factory

        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        sessionFactory.setDataSource(securityDataSource());
        sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
        sessionFactory.setHibernateProperties(getHibernateProperties());

        return sessionFactory;

    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){

        //set up the transaction manager

        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);

        return txManager;

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**","/webjars/**")
                .addResourceLocations("/resources/", "/webjars/");
    }

}
