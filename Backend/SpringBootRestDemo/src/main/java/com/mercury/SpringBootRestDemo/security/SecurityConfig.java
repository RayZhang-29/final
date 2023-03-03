package com.mercury.SpringBootRestDemo.security;

import com.mercury.SpringBootRestDemo.security.handler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    @Autowired
    private AuthenticationEntryPointImpl authenticationEntryPointImpl;

    @Autowired
    private AccessDeniedHandlerImpl accessDeniedHandlerImpl;

    @Autowired
    private AuthenticationSuccessHandlerImpl authenticationSuccessHandlerImpl;

    @Autowired
    private AuthenticationFailureHandlerImpl authenticationFailureHandlerImpl;

    @Autowired
    private LogoutSuccessHandlerImpl logoutSuccessHandlerImpl;

    @Autowired
    private UserDetailsService userDetailsServiceImpl;

    @Bean   // put the return into the spring bean container, as a bean, function name is the bean name
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors();

        http.authorizeRequests((requests) ->
                        requests
//                                .antMatchers(HttpMethod.GET, "/orders")
//                                .hasRole("USER")
//                                .hasAuthority("ROLE_ADMIN")
//
//                                .antMatchers(HttpMethod.GET, "/orders/*")
//                                .hasAnyRole("ADMIN", "USER")

                                .anyRequest().permitAll()   //.authenticated()
        );

        http.exceptionHandling()
                .accessDeniedHandler(accessDeniedHandlerImpl)
                .authenticationEntryPoint(authenticationEntryPointImpl);

        http.formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler(authenticationSuccessHandlerImpl)
                .failureHandler(authenticationFailureHandlerImpl)
        ;

        http.logout()
                .permitAll()
                .logoutUrl("/logout")
                .logoutSuccessHandler(logoutSuccessHandlerImpl)
        ;

        http.httpBasic();
        return http.build();
    }

    @Bean // put the return object into spring container, as a bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }

    @Autowired // @Autowired on function will autowired the parameters
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(new BCryptPasswordEncoder(11));
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*"); // You should only set trusted site here. e.g. http://localhost:4200 means only this site can access.
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","HEAD","OPTIONS"));
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
