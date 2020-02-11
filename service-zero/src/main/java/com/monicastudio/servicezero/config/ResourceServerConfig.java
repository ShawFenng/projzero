package com.monicastudio.servicezero.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import com.monicastudio.mscommon.utils.DemoPasswordEncoder;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private static final String DEMO_RESOURCE_ID = "black";

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new DemoPasswordEncoder();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//        resources.resourceId(DEMO_RESOURCE_ID).stateless(true);
        super.configure(resources);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/hello/white").permitAll()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .anyRequest()
                .authenticated();
    }

}
