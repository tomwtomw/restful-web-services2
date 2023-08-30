package com.in28minutes.rest.webservices.restfulwebservices2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {
    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception {
        // all requests should be authenticated
        http.authorizeHttpRequests(auth->auth.anyRequest().authenticated());
        // If request is not authenticated web page is shown
        http.httpBasic(withDefaults());
        //crsf disabled
        //noinspection removal
        http.csrf().disable();

        return http.build();
    }
}
