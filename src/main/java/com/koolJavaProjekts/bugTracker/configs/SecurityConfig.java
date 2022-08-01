package com.koolJavaProjekts.bugTracker.configs;

import com.koolJavaProjekts.bugTracker.Services.NewUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private NewUserDetailsService userDetailsService;
    @Autowired
    private final SessionFilter sessionFilter;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public SecurityConfig(NewUserDetailsService userDetailsService, SessionFilter sessionFilter, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.sessionFilter = sessionFilter;
        this.passwordEncoder = passwordEncoder;
    }

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
                .cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/api/login").permitAll()
                .antMatchers("/user").permitAll()
                .antMatchers("/home").authenticated()
                .antMatchers("/register").permitAll()
                .and().formLogin()
                .and().httpBasic();
        http.addFilterBefore(sessionFilter, UsernamePasswordAuthenticationFilter.class);
    }
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
