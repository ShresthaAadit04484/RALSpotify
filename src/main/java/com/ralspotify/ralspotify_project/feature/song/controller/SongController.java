package com.ralspotify.ralspotify_project.feature.song.controller;

import java.util.List;

import com.ralspotify.ralspotify_project.feature.song.service.SongService;
import com.ralspotify.ralspotify_project.feature.song.model.Song;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/song")
public class SongController {
    private SongService songService;

    public SongController(SongService songService){
        this.songService = songService;
    }

    //Create songs
    @PostMapping()
    public ResponseEntity<Song> saveSong(@RequestBody Song song) {       
        Song savedSong = songService.saveSong(song);
        return ResponseEntity.ok(savedSong);
    }
    
    //Get all songs
    @GetMapping
    public ResponseEntity<List<Song>> getAllSongs() {
        List<Song> songs = songService.getAllSongs();
        return ResponseEntity.ok(songs);
    }
    
    //Get songs by id
    @GetMapping("/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable Long id){
        return songService.getSongById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());            
    }

    //Get songs by title
    @GetMapping("/title/{title}")
    public ResponseEntity<Song> getSongByTitle(@PathVariable String title){
        return songService.getSongByTitle(title)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    //Get songs by artist
    @GetMapping("/artist/{artist}")
    public ResponseEntity<Song> getSongByArtist(@PathVariable String artist){
        return songService.getSongByArtist(artist)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    //Delete song
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSongById(@PathVariable Long id){
        if (songService.getSongById(id).isPresent()){
            songService.deleteSong(id);
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
