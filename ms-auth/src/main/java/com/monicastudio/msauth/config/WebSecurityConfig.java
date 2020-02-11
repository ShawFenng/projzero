package com.monicastudio.msauth.config;

import com.monicastudio.mscommon.utils.DemoPasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("monica")
                .password(passwordEncoder().encode("123456"))
                .authorities(new ArrayList<>());
    }

    /**
     * ‘@Bean’注解用来解决AuthorizationServerConfig中无法注入AuthenticationManager的错误
     *
     * @author Shawn Fenng
     * 2020-02-10 18:40
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * SpringSecurity不允许明文传输密码，需要注入PasswordEncoder
     *
     * @author Shawn Fenng
     * 2020-02-10 19:59
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new DemoPasswordEncoder();
    }
}
