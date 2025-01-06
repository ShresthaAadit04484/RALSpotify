package com.ralspotify.ralspotify_project.feature.playlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ralspotify.ralspotify_project.feature.playlist.model.Playlist;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long>{
    public Playlist findByName(String name);
}
