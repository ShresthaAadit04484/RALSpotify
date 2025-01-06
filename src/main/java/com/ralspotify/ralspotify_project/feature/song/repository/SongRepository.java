package com.ralspotify.ralspotify_project.feature.song.repository;

import com.ralspotify.ralspotify_project.feature.song.model.Song;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long>{
    public Song findByTitle(String title);
    public Song findByArtist(String artist);
    public Song findByAlbum(String album);
}
