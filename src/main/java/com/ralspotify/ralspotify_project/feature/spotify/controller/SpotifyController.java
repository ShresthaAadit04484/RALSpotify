package com.ralspotify.ralspotify_project.feature.spotify.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpotifyController {
    
    @GetMapping("/home")
    public String home() {
        return "Welcome to RALSpotify! OAuth 2.0 Login Successful.";
    }
}
