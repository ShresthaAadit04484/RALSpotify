package com.ralspotify.ralspotify_project.feature.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ralspotify.ralspotify_project.feature.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    public User findByEmail(String email);
    public User findByUsername(String username);
}
