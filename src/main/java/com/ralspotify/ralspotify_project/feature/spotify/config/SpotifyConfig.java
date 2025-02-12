package com.ralspotify.ralspotify_project.feature.spotify.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpotifyConfig {

    @Bean
    public SecurityFilterChain spotifySecurityFilterChain(HttpSecurity http) throws Exception {
        http
            .securityMatcher("/callback", "/login/oauth2/**", "/oauth2/**") // Only handle Spotify OAuth2 endpoints
            .csrf(customizer -> customizer.disable()) // Disable CSRF for OAuth2
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // Allow all requests to Spotify OAuth2 endpoints
            )
            .oauth2Login(oauth -> oauth
                .defaultSuccessUrl("/spotify/home", true) // Redirect after successful login
                .redirectionEndpoint(redirection -> redirection
                    .baseUri("/callback") // Use custom callback URL
                )
            );
        return http.build();
    }
}