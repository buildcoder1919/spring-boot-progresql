package com.main.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Data
@Component
@ConfigurationProperties("spring.datasource")
public class DataSourceConfiguration {

    private String driver;
    private String url;
    private String username;
    private String password;

    @Bean
    public DataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        // 关闭连接后不自动提交
        dataSource.setAutoCommitOnClose(false);

        return dataSource;
    }
}
