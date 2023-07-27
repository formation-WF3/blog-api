package com.formation.blogapi.controllers;

import com.formation.blogapi.entities.UserEntity;
import com.formation.blogapi.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public Collection<UserEntity> findAll() {
        return userRepository.findAll();
    }

//    @PostMapping
//    public UserEntity create(@RequestBody UserEntity user) {
//        return userRepository.save(user);
//    }

    // Remplace le create en plus de faire l'update, c'est une autre solution
    @RequestMapping(value = "", method = {RequestMethod.POST, RequestMethod.PUT})
    public UserEntity update(@RequestBody UserEntity user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public UserEntity findById(@PathVariable Integer id) {
        return userRepository.findById(id).orElse(null);
    }
}
