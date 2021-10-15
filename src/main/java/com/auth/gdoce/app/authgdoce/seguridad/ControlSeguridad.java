/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auth.gdoce.app.authgdoce.seguridad;

import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

/**
 *
 * @author DELL
 */
public class ControlSeguridad extends WebSecurityConfigurerAdapter {
    
       protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(a -> a.antMatchers("/", "/url/**", "/error",
                "/webjars/**", "/Reservation/**", "/client/**", "/Gama/**",
                "/Car/**", "/client/**", "/Score/**", "/Message/**,/api/mensaje/**").permitAll()
                .anyRequest().authenticated()
        ).exceptionHandling(e -> e
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))                             
        ).oauth2Login();  
        http.cors().and().csrf().disable();
        
       
    }
    
}
