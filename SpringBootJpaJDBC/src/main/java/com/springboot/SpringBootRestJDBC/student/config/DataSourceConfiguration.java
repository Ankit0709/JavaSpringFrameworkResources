package com.springboot.SpringBootRestJDBC.student.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;


import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.hikari.maximumPoolSize}")
    private int maximumPoolSize;

    @Value("${spring.datasource.hikari.minimumIdle}")
    private int minimumIdle;
    @Value("${spring.datasource.hikari.connectionTimeout}")
    private long connectionTimeout;

    @Value("${spring.datasource.hikari.idleTimeout}")
    private long idleTimeout;

    @Value("${spring.datasource.hikari.maxLifetime}")
    private long maxLifeTime;


    @Bean(name = "customDataSource")
    public DataSource customDataSource(){
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(url);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        hikariConfig.setMaximumPoolSize(maximumPoolSize);
        hikariConfig.setMinimumIdle(minimumIdle);
        hikariConfig.setConnectionTimeout(connectionTimeout);
        hikariConfig.setIdleTimeout(idleTimeout);
        hikariConfig.setMaxLifetime(maxLifeTime);
       return new HikariDataSource(hikariConfig);

    }
    public JdbcTemplate getJDBCTemplate(@Qualifier("customDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
