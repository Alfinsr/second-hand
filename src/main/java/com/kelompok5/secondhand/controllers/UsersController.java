package com.kelompok5.secondhand.controllers;

import com.kelompok5.secondhand.dto.UsersDto;
import com.kelompok5.secondhand.entity.Users;
import com.kelompok5.secondhand.services.CloudinaryStorageService;
import com.kelompok5.secondhand.services.UsersServices;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController @RequiredArgsConstructor
public class UsersController {
    @Autowired
    private final UsersServices usersServices;

    @Autowired
    private final CloudinaryStorageService cloudinaryStorageService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/signup")
    public ResponseEntity<Users> postUsers(@RequestBody UsersDto usersDto) {
        Users users = modelMapper.map(usersDto, Users.class);
        return new ResponseEntity<>(usersServices.postUsers(users), HttpStatus.CREATED);
    }

    @GetMapping("/Users")
    public ResponseEntity<List<Users>> getAllUsers() {
        return new ResponseEntity<>(usersServices.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/current")
    public String currentUser(Authentication authentication){
        return authentication.getName();
    }

    @GetMapping("/Users/{id}")
    public ResponseEntity<Optional<Users>> getUsersById(@PathVariable Integer id) {
        return new ResponseEntity<>(usersServices.getUserById(id), HttpStatus.OK);
    }

    @PutMapping("/Users")
    public ResponseEntity<Users> updateUsers(@RequestBody UsersDto usersDto, Authentication authentication) {
       String username =  authentication.getName();
        Map<?, ?> uploadImage = (Map<?, ?>) cloudinaryStorageService.upload(usersDto.getProfileFoto()).getData();
        Users users = new Users();
        users.setKota(usersDto.getKota());
        users.setEmail(usersDto.getEmail());
        users.setFullName(usersDto.getFullName());
        users.setAlamat(usersDto.getAlamat());
        users.setNoWa(usersDto.getNoWa());
        users.setProfileFoto(uploadImage.get("url").toString());
        users.setUsername(usersDto.getUsername());
        users.setPassword(usersDto.getPassword());

        return new ResponseEntity<>(usersServices.updateUsers(users, username), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/Users/{id}")
    public ResponseEntity<String> deleteUsers(@PathVariable Integer id){
        return new ResponseEntity<>(usersServices.deleteUser(id), HttpStatus.ACCEPTED);
    }
}