package com.ralspotify.ralspotify_project.feature.song.service;

import com.ralspotify.ralspotify_project.feature.song.model.Song;
import com.ralspotify.ralspotify_project.feature.song.repository.SongRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    private final SongRepository songRepository;

    public SongService(SongRepository songRepository){
        this.songRepository = songRepository;
    }

    //Create or Update Song
    public Song saveSong(Song song){
        return songRepository.save(song);
    }

    //Get all songs
    public List<Song> getAllSongs(){
        return songRepository.findAll();
    }

    //Get Song By ID
    public Optional<Song> getSongById(Long id){
        return songRepository.findById(id);
    }

    public Optional<Song> getSongByArtist(String artist){
        return Optional.ofNullable(songRepository.findByArtist(artist));
    }

    public Optional<Song> getSongByTitle(String title){
        return Optional.ofNullable(songRepository.findByTitle(title));
    }
    
    public void deleteSong(Long id){
        songRepository.deleteById(id);
    }
}
