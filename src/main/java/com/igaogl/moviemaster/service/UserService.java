package com.igaogl.moviemaster.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.igaogl.moviemaster.model.User;
import com.igaogl.moviemaster.repository.UserRepository;

@Service
public class UserService {
    
    private @Autowired UserRepository userRepository;
    
    public Optional<User> createUser(User user) {
        Optional<User> newUser = userRepository.findByUserNameIgnoreCase(user.getUserName());

        if (newUser.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with the username: " + user.getUserName() + " already exists.", null);
        }

        return Optional.ofNullable(userRepository.save(user));
    }

    public List<User> findAllUsers() {
        List<User> userList = userRepository.findAll(); // findAll is already a method implemented by JPARepository, we're just using it

        if (userList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "User list is empty", null);
        }
        return userList;
    } 

}
