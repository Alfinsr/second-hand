package com.kelompok5.secondhand.controllers;

import com.kelompok5.secondhand.dto.UsersDto;
import com.kelompok5.secondhand.entity.Users;
import com.kelompok5.secondhand.services.UsersServices;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequiredArgsConstructor
public class UsersController {

    @Autowired
    private final UsersServices usersServices;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/signup")
    public ResponseEntity<Users> postUsers(@RequestBody UsersDto usersDto){
        Users users = modelMapper.map(usersDto, Users.class);
        return new ResponseEntity<>(usersServices.postUsers(users), HttpStatus.CREATED);
    }
}
