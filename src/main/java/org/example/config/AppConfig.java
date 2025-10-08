package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javax.sql.DataSource;
import java.io.InputStream;
import java.io.OutputStream;

@Configuration
public class AppConfig {
    @Bean
    public InputStream inputStream(){return System.in;}
    @Bean
    public OutputStream outputStream(){return System.out;}
}
