package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/login", "/callback", "/error").permitAll() // allowed without login
                .anyRequest().authenticated() // all other endpoints need authentication
            )
            .oauth2Login(); // enables OAuth2 login with GitHub

        return http.build();
    }
}
