package com.kelompok5.secondhand.controllers;

import com.kelompok5.secondhand.dto.UsersDto;
import com.kelompok5.secondhand.entity.Users;
import com.kelompok5.secondhand.result.Result;
import com.kelompok5.secondhand.services.CloudinaryStorageService;
import com.kelompok5.secondhand.services.UsersServices;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController @RequiredArgsConstructor
public class UsersController {
    @Autowired
    private final UsersServices usersServices;

    @Autowired
    private final CloudinaryStorageService cloudinaryStorageService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/signup")
    public ResponseEntity<Result> postUsers(@RequestBody UsersDto usersDto) {
        Users users = modelMapper.map(usersDto, Users.class);
        return new ResponseEntity<>(usersServices.postUsers(users), HttpStatus.CREATED);
    }



    @GetMapping("/current")
    public String currentUser(Authentication authentication){
        return authentication.getName();
    }

    @GetMapping("/Users")
    public ResponseEntity<Result> getUsersById(Authentication authentication) {
        return new ResponseEntity<>(usersServices.getUserById(authentication.getName()), HttpStatus.OK);
    }


    @PutMapping("/Users")
    public ResponseEntity<Result> updateUsers(UsersDto usersDto, Authentication authentication) {
       String username =  authentication.getName();
        return new ResponseEntity<>(usersServices.updateUsers(usersDto, username), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/Users/{id}")
    public ResponseEntity<Result> deleteUsers(@PathVariable Integer id){
        return new ResponseEntity<>(usersServices.deleteUser(id), HttpStatus.ACCEPTED);
    }

    @PutMapping("/Users-password")
    public ResponseEntity<Result> updatePassword(UsersDto usersDto, Authentication authentication){
        return new ResponseEntity<>(usersServices.updatePassword(usersDto, authentication.getName()), HttpStatus.ACCEPTED);
    }
}