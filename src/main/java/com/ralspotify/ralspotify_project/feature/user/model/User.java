package com.ralspotify.ralspotify_project.feature.user.model;

import java.util.List;
import java.util.ArrayList;

import com.ralspotify.ralspotify_project.feature.song.model.Song;
import com.ralspotify.ralspotify_project.feature.playlist.model.Playlist;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToMany;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String username;

    private String mobile;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    private String password;

    @ManyToMany
    @JoinTable(
        name = "user_favourite_songs",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    private List<Song> favouriteSongs = new ArrayList<>();
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Playlist> playlists = new ArrayList<>();
    
    //Constructors
    public User(){
        super();
    }

    //Parametarized Constructor
    public User(Long id, String email, String username, String mobile, Gender gender, String password){
        super();
        this.id = id;
        this.email = email;
        this.username = username;
        this.mobile = mobile;
        this.gender = gender;
        this.password = password;
    }


    //Getter and Setter
    public Long getID(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getMobile(){
        return mobile;
    }

    public void setMobile(String mobile){
        this.mobile = mobile;
    }
    
    public Gender getGender(){
        return gender;
    }

    public void setGender(Gender gender){
        this.gender = gender;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }


    public List<Song> getFavouriteSongs(){
        return favouriteSongs;
    }

    public void setFavouriteSongs(List<Song> favouriteSongs){
        this.favouriteSongs = favouriteSongs;
    }
}
