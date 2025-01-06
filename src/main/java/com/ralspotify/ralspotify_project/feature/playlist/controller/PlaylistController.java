package com.ralspotify.ralspotify_project.feature.playlist.controller;

import java.util.List;

import com.ralspotify.ralspotify_project.feature.playlist.service.PlaylistService;
import com.ralspotify.ralspotify_project.feature.playlist.model.Playlist;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/playlist")
public class PlaylistController {
    private PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService){
        this.playlistService = playlistService;
    }

    @PostMapping
    public ResponseEntity<Playlist> createPlaylist(@RequestBody Playlist playlist) {
        Playlist savedPlaylist = playlistService.savePlaylist(playlist);
        return ResponseEntity.ok(savedPlaylist);
    }
    
    @GetMapping
    public ResponseEntity<List<Playlist>> getAllPlaylist(){
        List<Playlist> allPlaylist = playlistService.getAllPlaylist();
        return ResponseEntity.ok(allPlaylist);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Playlist> getPlaylistById(@PathVariable Long id){
        return playlistService.getPlaylistById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Playlist> getPlaylistByName(@PathVariable String name){
        return playlistService.getPlaylistByName(name)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlaylistById(@PathVariable Long id){
        if (playlistService.getPlaylistById(id).isPresent()){
            playlistService.deletePlaylistById(id);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
