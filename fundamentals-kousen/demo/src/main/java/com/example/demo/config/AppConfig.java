package com.example.demo.config;

import com.example.demo.json.Greeting;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Greeting defaultGreeting() {
        return new Greeting("Hello, World!");
    }

    @Bean
    public Greeting yoGreeting() {
        return new Greeting("Yo!");
    }
}
