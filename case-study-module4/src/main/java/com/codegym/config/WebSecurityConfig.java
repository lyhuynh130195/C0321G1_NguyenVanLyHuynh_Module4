package com.codegym.config;

import com.codegym.model.service.impl.MyUserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    MyUserDetailServiceImpl myUserDetailService;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().formLogin().loginPage("/login").defaultSuccessUrl("/home").permitAll().
                and().authorizeRequests()
                .antMatchers("home").permitAll()
                .antMatchers("/employee/**").hasRole("ADMIN")
                .antMatchers("/service/**").hasAnyRole("ADMIN","USER")
                .antMatchers("/contract/**").hasAnyRole("ADMIN","USER")
                .antMatchers("/customer/**").hasAnyRole("ADMIN","USER")
                .antMatchers("/contract_detail/**").hasAnyRole("ADMIN","USER")
                .anyRequest().authenticated();
//        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/error_403");
        http.authorizeRequests().and().rememberMe().tokenRepository(this.persistentTokenRepository())
                .tokenValiditySeconds(36000);
    }

    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl memoryTokenRepository = new InMemoryTokenRepositoryImpl();
        return memoryTokenRepository;
    }
}

