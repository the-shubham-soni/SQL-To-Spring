package com.example.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Allow CORS for all end points
                .allowedOrigins("http://localhost:4200") // Allow requests from Angular app (localhost:4200)
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow these HTTP methods
                .allowCredentials(true); // Allow credentials if needed
    }
}
