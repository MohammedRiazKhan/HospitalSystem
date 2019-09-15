package me.mohammedriazkhan.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Security extends WebSecurityConfigurerAdapter {

    //define all the users and their roles.

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{


        auth.inMemoryAuthentication()
                .withUser("riaz")
                .password("{noop}khan") //if you dont want to use a password encoder {noop} before password
                .roles("DOCTOR")//or .roles("PASS IN ROLE)
                .and()
                .withUser("Mohammed")
                .password("{noop}khan")
                .roles("DOCTOR", "NURSE");


    }


    @Override
    protected void configure(HttpSecurity http) throws Exception{

        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/doctor/getAll")
                .hasRole("DOCTOR")
                .and()
                .csrf().disable();

    }

    //bEncrypt. ==>should return a format like = {encoder}xxxx
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }




}