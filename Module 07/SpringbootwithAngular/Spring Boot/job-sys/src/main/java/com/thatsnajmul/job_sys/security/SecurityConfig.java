package com.thatsnajmul.job_sys.security;

import com.thatsnajmul.job_sys.jwt.JwtAuthenticationFilter;
import com.thatsnajmul.job_sys.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserService userService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return
                http

                        .csrf(AbstractHttpConfigurer::disable)
                        .cors(Customizer.withDefaults())
                        .authorizeHttpRequests(

                                req ->
                                        req.requestMatchers("/login",
                                                        "/register/job-seeker", "api/users/**", "/api/access/users",
                                                                "/api/jobs","/api/jobs/search", "/api/jobs/{id}",
                                                                "/api/jobs/get/search", "/api/jobs/get",
                                                                "/activate/**",
                                                                "/swagger-ui.html/**",
                                                                "/images/**")
                                                .permitAll()

                                                .requestMatchers("/api/job-applications", "/api/job-applications/{id}",
                                                                 "/api/jobs/", "/api/jobs/{id}",
                                                                 "/api/jobs/get/search", "/api/jobs/get",
                                                                 "/api/personal-details", "/api/personal-details/search", "/api/personal-details/{id}",
                                                                 "/api/personal-details", "/api/personal-details/search", "/api/personal-details/{id}")
                                                .hasAuthority("ADMIN")

                                                .requestMatchers("/api/jobs", "/api/jobs/{id}","/api/job-applications", "/api/job-applications/{id}")
                                                .hasAuthority( "EMPLOYER")

                                                .requestMatchers("/api/personal-details")
                                                .hasAuthority("JOB_SEEKER")

                                                //For all User
                                                .requestMatchers("api/users/**")
                                                .hasAuthority("JOB_SEEKER,EMPLOYER,ADMIN")



                        )
                        .userDetailsService(userService)
                        .sessionManagement(
                                session ->
                                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        )
                        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                        .build();


    }



    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }


    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:4200", "http://127.0.0.1:4200"));  // Add allowed origins
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);  // Apply CORS settings to all endpoints
        return source;
    }




}
