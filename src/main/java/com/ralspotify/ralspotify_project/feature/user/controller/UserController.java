package com.ralspotify.ralspotify_project.feature.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ralspotify.ralspotify_project.feature.user.model.User;
import com.ralspotify.ralspotify_project.feature.song.model.Song;
import com.ralspotify.ralspotify_project.feature.user.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/api/users")
public class UserController {
    
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    //Create or Update User    
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser); 
    }

    //Get User by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    //Get all Users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    //Get Users by Email
    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id){
        if (userService.getUserById(id).isPresent()){
            userService.deleteByUserId(id);
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }



    //Favourite Songs
    @PostMapping("/{userId}/favourites/{songId}")
    public ResponseEntity<User> addFaovouriteSong(@PathVariable Long userId,@PathVariable Long songId){
        User updatedUser = userService.addFavouriteSongs(userId, songId);
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping("/{userId}/favourites")
    public ResponseEntity<List<Song>> getUserFavouriteSongs(@PathVariable Long userId){
        User user = userService.getUserById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found"));
        List<Song> favouriteSongs = user.getFavouriteSongs();
        return ResponseEntity.ok(favouriteSongs);
    }

    @DeleteMapping("/{userId}/favourites/{songId}")
    public ResponseEntity<User> removeFavouriteSong(@PathVariable Long userId, @PathVariable Long songId){
        User updatedUser = userService.removeFavouriteSong(userId, songId);
        return ResponseEntity.ok(updatedUser);
    }
}
