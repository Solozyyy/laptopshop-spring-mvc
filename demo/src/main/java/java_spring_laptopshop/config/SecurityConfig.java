package java_spring_laptopshop.config;

//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

//Disable spring security
@Configuration
// @ConditionalOnProperty(name = "app.security.enabled", havingValue = "true",
// matchIfMissing = false)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // allow all requestsrequests
                )
                .csrf(csrf -> csrf.disable()); // No CSRFCSRF

        return http.build();
    }
}
