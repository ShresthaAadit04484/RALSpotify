package com.ralspotify.ralspotify_project.feature.user.service;

import java.util.List;
import java.util.Optional;
import com.ralspotify.ralspotify_project.feature.user.model.User;
import com.ralspotify.ralspotify_project.feature.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.ralspotify.ralspotify_project.feature.song.model.Song;
import com.ralspotify.ralspotify_project.feature.song.service.SongService;

@Service
public class UserService {
    private final UserRepository userRepo;
    private final SongService songService;
    
    public UserService(UserRepository userRepo, SongService songService){
        this.userRepo = userRepo;
        this.songService = songService;
    }

    //Create or Update User
    public User saveUser(User user){
        return userRepo.save(user);
    }

    //Get all users
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    //Get user by id
    public Optional<User> getUserById(Long id){
        return userRepo.findById(id);
    }

    //Delete user by id
    public void deleteByUserId(Long id){
        userRepo.deleteById(id);
    }

    //Get user by Email
    public Optional<User> getUserByEmail(String email){
        return Optional.ofNullable(userRepo.findByEmail(email));
    }

    //Get user by Username
    public Optional<User> getUserByUsername(String username){
        return Optional.ofNullable(userRepo.findByUsername(username));
    }


    public User addFavouriteSongs(Long userId, Long songId){
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Song song = songService.getSongById(songId).orElseThrow(() -> new RuntimeException("Song not found"));

        user.getFavouriteSongs().add(song);
        return userRepo.save(user);
    }

    public User removeFavouriteSong(Long userId, Long songId){
        User user = getUserById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Song song = songService.getSongById(songId).orElseThrow(() -> new RuntimeException("Song not found to delete"));

        user.getFavouriteSongs().remove(song);
        return userRepo.save(user);
    } 
}
