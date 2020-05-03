package com.iiitb.sellerportal.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class LoginSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Qualifier("loginDetailsServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.cors().and().csrf().disable();

//        httpSecurity.antMatcher("/seller/**")
//                .authorizeRequests()
//                .antMatchers("/seller/**").access("hasRole('SELLER')")
//                .and()
//
//                .formLogin().permitAll()//loginPage("/seller/login")
////                .loginProcessingUrl("/seller/applogin")
////                .defaultSuccessUrl("/seller/dashboard")
////                .failureUrl("/seller/login?error")
//                .usernameParameter("username").passwordParameter("password")
//
//                .and()
//                .logout()//logoutUrl("/seller/logout")
////                .logoutSuccessUrl("/seller/login?logout")
//                .deleteCookies("JSESSIONID")
//                .invalidateHttpSession(true);
//
////                .and()
////                .exceptionHandling().accessDeniedPage("/superadmin-panel/accessDenied");

        //String userRedirect=userDetailsService.loadUserByUsername().
        httpSecurity.authorizeRequests()
                    .antMatchers("/seller/register").permitAll()
                    .antMatchers("/company/register").permitAll()
                    .antMatchers("/seller/**").hasRole("SELLER")
                    .antMatchers("/company/**").hasRole("COMPANY")
                    .anyRequest().fullyAuthenticated()
                    .and()
                    .formLogin().successHandler(authenticationSuccessHandler).permitAll();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

}
