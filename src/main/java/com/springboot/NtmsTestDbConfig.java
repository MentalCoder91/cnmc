package com.springboot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "ntmsTestDbEntityManagerFactory",
        transactionManagerRef = "ntmsTestDbTransactionManager",
        basePackages = { "com.springboot.ntmstest" }
)
public class NtmsTestDbConfig {

    @Bean(name="NtmsTestDbDataSource")
    @ConfigurationProperties(prefix="spring.seconddatasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "ntmsTestDbEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory
            (EntityManagerFactoryBuilder builder,@Qualifier("NtmsTestDbDataSource") DataSource primaryDataSource) {
        return builder
                .dataSource(primaryDataSource)
                .packages("com.springboot.ntmstest")
                .build();
    }




    @Bean(name = "ntmsTestDbTransactionManager")
    public PlatformTransactionManager primaryTransactionManager(
            @Qualifier("ntmsTestDbEntityManagerFactory") EntityManagerFactory primaryEntityManagerFactory) {
        return new JpaTransactionManager(primaryEntityManagerFactory);
    }
}