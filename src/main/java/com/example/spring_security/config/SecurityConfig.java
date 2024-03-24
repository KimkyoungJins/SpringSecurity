package com.example.spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean   // 의존성 주입
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http  // 라는 것을 통해서 제어를 한다.
                .authorizeHttpRequests((auth) -> auth   // 누가 들어오고 못들어오고를 제한한다.
                        .requestMatchers("/", "/login", "/loginProc", "join", "joinProc").permitAll()   // 모든사람?
                        .requestMatchers("/admin").hasRole("ADMIN")     // 특정역할
                        .requestMatchers("/my/**").hasAnyRole("ADMIN", "USER")  // 특정한 역할
                        .anyRequest().authenticated()           // 로그인 인증을 한 사람에 한해서, 인가해주는 것이다.
                );


        http
                .formLogin((auth) -> auth.loginPage("/login")      // 로그인 창에
                        .loginProcessingUrl("/loginProc")           // 로그인 창에 누구나 접근할 수 있도록
                        .permitAll()
                );

        http
                .csrf((auth) -> auth.disable());        // 보호할 수 있도록 특정
        http
                .sessionManagement((auth) -> auth
                        .maximumSessions(1)
                        .maxSessionsPreventsLogin(true));


        return http.build();
    }
}