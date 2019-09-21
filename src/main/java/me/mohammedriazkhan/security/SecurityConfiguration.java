package me.mohammedriazkhan.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String USER_ROLE = "USER";
    private static final String ADMIN_ROLE = "ADMIN";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{

        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(encoder().encode("admin"))
                .roles(ADMIN_ROLE)
                .and()
                .withUser("user")
                .password(encoder().encode("user"))
                .roles(USER_ROLE);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{

        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/report/getall")
                .hasRole(ADMIN_ROLE)
                .and()
                .csrf().disable();

    }

    @Bean
    public PasswordEncoder encoder(){
       return new BCryptPasswordEncoder();
    }




}