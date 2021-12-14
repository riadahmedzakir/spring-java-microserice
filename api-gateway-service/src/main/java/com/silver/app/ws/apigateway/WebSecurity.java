// package com.silver.app.ws.apigateway;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.core.env.Environment;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.config.http.SessionCreationPolicy;

// @Configuration
// @EnableWebSecurity
// public class WebSecurity extends WebSecurityConfigurerAdapter {
//     private final Environment _environment;

//     @Autowired
//     public WebSecurity(Environment environment) {
//         this._environment = environment;
//     }

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         String actuatorUrl = _environment.getProperty("api.users.actuator.url.path");
//         String h2ConsoleUrl = _environment.getProperty("api.h2console.url.path");
//         String registrationUrl = _environment.getProperty("api.registration.url.path");
//         String loginUrl = _environment.getProperty("api.login.url.path");

//         http.csrf().disable();
//         http.headers().frameOptions().disable();
//         http.authorizeRequests()
//                 .antMatchers(actuatorUrl).permitAll()
//                 .antMatchers(h2ConsoleUrl).permitAll()
//                 .antMatchers(HttpMethod.POST, registrationUrl).permitAll()
//                 .antMatchers(HttpMethod.POST, loginUrl).permitAll()
//                 .anyRequest().authenticated()
//                 .and()
//                 .addFilter(new CustomAuthorizationFilter(authenticationManager(), _environment));

//         http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

//     }
// }
