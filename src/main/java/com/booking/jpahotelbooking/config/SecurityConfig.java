package com.booking.jpahotelbooking.config;

import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.http.SessionCreationPolicy;
import com.booking.jpahotelbooking.auth.util.JWTTokenFilter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Configuration;
import com.booking.jpahotelbooking.service.EmployeeService;
import com.booking.jpahotelbooking.service.GuestService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final EmployeeService employeeService;
    private final GuestService guestService;
    private final JWTTokenFilter jwtTokenFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/employees/byFullName").authenticated()
                .requestMatchers("/employees/**").hasAnyRole("MODERATOR", "ADMIN")
                .requestMatchers("/guest/**").hasAnyRole("MODERATOR", "ADMIN")
                .requestMatchers("/registrations/**").hasAnyRole("MODERATOR", "ADMIN")
                .requestMatchers("/rooms/**").hasAnyRole("MODERATOR", "ADMIN")
                .anyRequest().permitAll()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                .and()
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider guestDaoAuthenticationProvider() {

        DaoAuthenticationProvider guestDaoAuthenticationProvider = new DaoAuthenticationProvider();
        guestDaoAuthenticationProvider.setUserDetailsService(guestService);
        guestDaoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());

        return guestDaoAuthenticationProvider;
    }

    @Bean
    public DaoAuthenticationProvider employeeDaoAuthenticationProvider() {

        DaoAuthenticationProvider employeeDaoAuthenticationProvider = new DaoAuthenticationProvider();
        employeeDaoAuthenticationProvider.setUserDetailsService(employeeService);
        employeeDaoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());

        return employeeDaoAuthenticationProvider;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}