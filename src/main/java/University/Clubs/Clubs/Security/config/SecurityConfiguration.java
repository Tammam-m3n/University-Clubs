package University.Clubs.Clubs.Security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static University.Clubs.Clubs.Security.user.Role.ADMIN;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {



    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req ->
                        req
                                .requestMatchers("/api/v1/auth/**").permitAll()
//                                .requestMatchers("api/v1/auth/admin/**").hasRole(ADMIN.name())
//                                .requestMatchers("api/v1/auth/management/**").hasAnyRole(ADMIN.name(),Manager.name())
//                                .requestMatchers(GET,"api/v1/manager/**").hasAnyAuthority(ADMIN_READ.name(),MANAGER_READ.name())
                                .requestMatchers("api/a/appointment/**").hasRole(ADMIN.name())
                                .requestMatchers("api/a/announcement/**").hasRole(ADMIN.name())
                                .requestMatchers("api/c/club/**").hasRole(ADMIN.name())




                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();

    }


}
