package lk.ijse.springboot.userService.config;

import jakarta.servlet.http.HttpServletRequest;
import lk.ijse.springboot.userService.filter.CsrfCookieFilter;
import lk.ijse.springboot.userService.filter.JWTGenerator;
import lk.ijse.springboot.userService.filter.JwtValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        CsrfTokenRequestAttributeHandler handler = new CsrfTokenRequestAttributeHandler();
        handler.setCsrfRequestAttributeName("_csrf");
        http
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(httpSecurityCsrfConfigurer ->
                        httpSecurityCsrfConfigurer.csrfTokenRequestHandler(handler)
                                .ignoringRequestMatchers("api/userService")
                                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
//                Origin
                .cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.configurationSource(
                        new CorsConfigurationSource() {
                            @Override
                            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                                CorsConfiguration corsConfiguration = new CorsConfiguration();
                                corsConfiguration.setAllowCredentials(true);
                                corsConfiguration.setAllowedOrigins(List.of("*"));
                                corsConfiguration.setMaxAge(3600L);
                                corsConfiguration.setExposedHeaders(List.of("Authorization")); //headers
                                corsConfiguration.setAllowedMethods(List.of("*"));
                                corsConfiguration.setAllowedHeaders(List.of("*"));
                                return corsConfiguration;
                            }
                        }
                ))
                .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new JWTGenerator(), BasicAuthenticationFilter.class)
                .addFilterBefore(new JwtValidator(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests(req -> {
                    req
                            .requestMatchers(HttpMethod.POST, "api/userService")
                            .permitAll()
                            .requestMatchers(HttpMethod.PUT, "api/userService")
                            .hasAnyRole("USER", "ADMIN")
                            .requestMatchers(HttpMethod.DELETE, "api/userService")
                            .hasAnyRole("USER", "ADMIN")
                            .requestMatchers(HttpMethod.GET, "api/userService/{id}")
                            .hasAnyRole("USER", "ADMIN")
                            .requestMatchers(HttpMethod.GET, "api/userService")
                            .hasRole("ADMIN");
                });
        http.formLogin(Customizer.withDefaults()); //login page ek eno
        http.httpBasic(Customizer.withDefaults()); //header (postmn wage )
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
