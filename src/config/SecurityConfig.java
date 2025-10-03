package com.deliverytech.delivery.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // 1. Permite o acesso ao Console H2 e a todas as suas sub-rotas
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll() 
                
                // 2. Opcional: Permite o acesso às rotas do seu HealthController sem autenticação
                .requestMatchers(AntPathRequestMatcher.antMatcher("/health")).permitAll() 
                .requestMatchers(AntPathRequestMatcher.antMatcher("/info")).permitAll() 
                
                .anyRequest().authenticated() // Todas as outras rotas exigem autenticação
            )
            // 3. Desabilita a proteção CSRF para o console H2
            .csrf(csrf -> csrf
                .ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**"))
            )
            // 4. Desabilita a proteção X-Frame-Options (essencial para que o console H2 carregue)
            .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));
            
        return http.build();
    }

}
