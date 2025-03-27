package com.khrd.mybatishomeworkhandler.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setUrl("jdbc:postgresql://localhost:5432/product");
        source.setUsername("nyfong");
        source.setPassword("fongfong");
        return source;
    }
}
