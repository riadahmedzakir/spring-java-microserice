package com.silver.ws.identityservice.application.security;

import com.silver.ws.identityservice.application.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    private Environment _environment;
    private UserService _userService;
    private BCryptPasswordEncoder _bCryptPasswordEncoder;

    @Autowired
    public WebSecurity(Environment environment, UserService userService,
            BCryptPasswordEncoder bCryptPasswordEncoder) {
        this._environment = environment;
        this._userService = userService;
        this._bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String gatewayIp = _environment.getProperty("gateway.ip");
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/**")
                .hasIpAddress(gatewayIp)
                .and()
                .addFilter(getAuthenticationFilter());
        // http.authorizeRequests().antMatchers("/**").permitAll();
        http.headers().frameOptions().disable();
    }

    private AuthenticationFilter getAuthenticationFilter() throws Exception {
        String loginUrlPath = _environment.getProperty("login.url.path");

        AuthenticationFilter authenticationFilter = new AuthenticationFilter(_userService, _environment,
                authenticationManager());
        // authenticationFilter.setAuthenticationManager(authenticationManager());
        authenticationFilter.setFilterProcessesUrl(loginUrlPath);
        return authenticationFilter;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(_userService).passwordEncoder(_bCryptPasswordEncoder);
    }
}
