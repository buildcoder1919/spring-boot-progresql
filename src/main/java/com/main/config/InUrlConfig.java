package com.main.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Data
public class InUrlConfig {

    @Value("${env.ip:http://localhost:8081}")
    private String userInfo ;
}
