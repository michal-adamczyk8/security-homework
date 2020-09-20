package com.kodilla.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
      httpSecurity.authorizeRequests()
              .mvcMatchers(HttpMethod.GET, "/test/m1")
              .hasAnyRole("R1", "R2", "R3")
              .mvcMatchers(HttpMethod.GET,"/test/m2").hasAnyRole("R2", "R3")
              .mvcMatchers(HttpMethod.GET, "/test/m3").hasAnyRole("R3")
              .anyRequest()
              .fullyAuthenticated()
              .and()
              .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("R1").password("r1").roles("R1");
        auth.inMemoryAuthentication().withUser("R2").password("r2").roles("R2");
        auth.inMemoryAuthentication().withUser("R3").password("r3").roles("R3");
    }

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
