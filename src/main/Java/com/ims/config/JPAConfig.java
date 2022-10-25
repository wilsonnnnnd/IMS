package com.ims.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.persistence.EntityManagerFactory;


//@EnableJpaRepositories: this tells Spring Data JPA to look for repository classes in the specified package
// in order to inject relevant code at runtime.
//@EnableTransactionManagement: this tells Spring Data JPA to generate code for transaction management at runtime.
//To enable Spring Data JPA, we need to create two beans: EntityManagerFactory and JpaTransactionManager.
//So create another configuration class named JpaConfig

@Configuration  //java based configuration indicating that the class can be used by the Spring IoC container as a source of bean definitions.
                //Spring @Configuration annotation indicates that the class has @Bean definition methods. So Spring container can process the class and generate Spring Beans to be used in the application.
@EnableJpaRepositories(basePackages = {"com.ims.model"})
@EnableTransactionManagement
public class JPAConfig {

    //the first method creates an instance of EntityManagerFactory to manage the persistence unit DB
    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("ImsDB");

        return factoryBean;
    }

    //next method creates an instance of JpaTransactionManager for the EntityManagerFactory created by the first method.
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);

        return transactionManager;
    }
}