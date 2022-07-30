package com.koolJavaProjekts.bugTracker.configs;

import com.koolJavaProjekts.bugTracker.Services.NewUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.logging.Logger;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private NewUserDetailsService userDetailsService;
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                        .withUser("admin")
                        .password(passwordEncoder.encode("password"))
                        .roles("ADMIN");
        auth
                .inMemoryAuthentication()
                        .withUser("user")
                                .password(passwordEncoder.encode("password"))
                                        .roles("USER");
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/home").authenticated()
                .antMatchers("/register").permitAll()
                .and().formLogin()
                .and().httpBasic();
    }
}
