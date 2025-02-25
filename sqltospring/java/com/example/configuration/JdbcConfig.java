package com.example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import com.example.util.DBConstants;
@Configuration
public class JdbcConfig {

    // Define the DataSource bean
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DBConstants.DRIVER_CLASS_NAME);
        dataSource.setUrl(DBConstants.DB_URL);
        dataSource.setUsername(DBConstants.SQL_USERNAME);
        dataSource.setPassword(DBConstants.SQL_PASSWORD);

        return dataSource;
    }

    // Define the JdbcTemplate bean
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
