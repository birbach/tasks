package ma.ysf.project.spring.security.config;

import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import ma.ysf.project.spring.security.filter.AuthorizationFilter;
import ma.ysf.project.spring.security.utils.JwtUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthorizationFilter jwtAuthFilter;

    private final AuthenticationProvider authenticationProvider;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       http
               .csrf().disable()
               .authorizeHttpRequests()
               .requestMatchers("/apis/users/**")
               .permitAll()
               .and()
               .authorizeHttpRequests()
               .requestMatchers("/apis/tasks/both/**").hasAnyAuthority("USER", "ADMIN")
               .and()
               .authorizeHttpRequests()
               .requestMatchers("/apis/tasks/admin/**").hasAuthority("ADMIN")
               .anyRequest()
               .authenticated()
               .and()
               .sessionManagement()
               .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
               .and()
               .authenticationProvider(authenticationProvider)
               .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http
                .build();
    }
}
