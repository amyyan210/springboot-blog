package com.codeup.blog;

import com.codeup.blog.services.UserDetailsLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsLoader userDetails;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
                .loginPage("/login")
                // user's home page, it can be any URL
                .defaultSuccessUrl("/posts")
                // Anyone can go to the login page
                .permitAll()
            .and()
                .authorizeRequests()
                // anyone can see the home and logout page
                .antMatchers("/", "/logout", "/posts", "/register")
                .permitAll()
            .and()
                .logout()
                // append a query string value
                .logoutSuccessUrl("/login?logout")
            .and()
                .authorizeRequests()
                // only authenticated users can create/edit ads
                .antMatchers("/posts/create", "/posts/{id}/edit")
                .authenticated()
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetails).passwordEncoder(passwordEncoder());
    }
}