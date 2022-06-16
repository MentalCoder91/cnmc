package com.springboot;

import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
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
        entityManagerFactoryRef = "ntmsDbEntityManagerFactory",
        transactionManagerRef = "ntmsDbTransactionManager",
        basePackages = { "com.springboot.ntmsdb" }
)
public class NtmsDbConfig {

    @Bean(name="NtmsDbDataSource")
    @Primary
    @ConfigurationProperties(prefix="spring.firstdatasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "ntmsDbEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory
            (EntityManagerFactoryBuilder builder,@Qualifier("NtmsDbDataSource") DataSource primaryDataSource) {
        return builder
                .dataSource(primaryDataSource)
                .packages("com.springboot.ntmsdb")
                .build();
    }




    @Bean(name = "ntmsDbTransactionManager")
    public PlatformTransactionManager primaryTransactionManager(
            @Qualifier("ntmsDbEntityManagerFactory") EntityManagerFactory primaryEntityManagerFactory) {
        return new JpaTransactionManager(primaryEntityManagerFactory);
    }
}