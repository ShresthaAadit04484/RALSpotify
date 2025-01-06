package com.ralspotify.ralspotify_project.feature.playlist.service;

import com.ralspotify.ralspotify_project.feature.playlist.repository.PlaylistRepository;
import com.ralspotify.ralspotify_project.feature.playlist.model.Playlist;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class PlaylistService {
    private final PlaylistRepository playlistRepo;

    public PlaylistService(PlaylistRepository playlistRepo){
        this.playlistRepo = playlistRepo;
    }

    public Playlist savePlaylist(Playlist playlist){
        return playlistRepo.save(playlist);
    }

    public List<Playlist> getAllPlaylist(){
        return playlistRepo.findAll();
    }

    public Optional<Playlist> getPlaylistById(Long id){
        return playlistRepo.findById(id);
    }

    public Optional<Playlist> getPlaylistByName(String name){
        return Optional.ofNullable(playlistRepo.findByName(name));
    }

    public void deletePlaylistById(Long id){
        playlistRepo.deleteById(id);
    }
}
