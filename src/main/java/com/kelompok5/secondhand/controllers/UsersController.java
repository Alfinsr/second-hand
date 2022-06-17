package com.kelompok5.secondhand.controllers;

import com.kelompok5.secondhand.dto.UsersDto;
import com.kelompok5.secondhand.entity.Users;
import com.kelompok5.secondhand.services.UsersServices;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController @RequiredArgsConstructor
public class UsersController {
    @Autowired
    private final UsersServices usersServices;

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

    @GetMapping("/Users/{id}")
    public ResponseEntity<Optional<Users>> getUsersById(@PathVariable Integer id) {
        return new ResponseEntity<>(usersServices.getUserById(id), HttpStatus.OK);
    }

    @PutMapping("/Users/{id}")
    public ResponseEntity<Users> updateUsers(@RequestBody UsersDto UsersDto, @PathVariable Integer id) {
        Users users = modelMapper.map(UsersDto, Users.class);
        return new ResponseEntity<>(usersServices.updateUsers(users, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/Users/{id}")
    public ResponseEntity<String> deleteUsers(@PathVariable Integer id){
        return new ResponseEntity<>(usersServices.deleteUser(id), HttpStatus.ACCEPTED);
    }
}