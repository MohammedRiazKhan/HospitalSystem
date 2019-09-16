package me.mohammedriazkhan.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{

        auth.inMemoryAuthentication()
                .withUser("riaz")
                .password("khan") //if you dont want to use a password encoder {noop} before password
                .roles("ADMIN")//or .roles("PASS IN ROLE)
                .and()
                .withUser("Mohammed")
                .password("{noop}khan")
                .roles("USER");


    }


    @Override
    protected void configure(HttpSecurity http) throws Exception{

        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/doctor/getAll")
                .hasRole("ADMIN")
                .and()
                .csrf().disable();

    }

    //bEncrypt. ==>should return a format like = {encoder}xxxx
    @Bean
    public PasswordEncoder encoder(){
       return NoOpPasswordEncoder.getInstance();
    }




}