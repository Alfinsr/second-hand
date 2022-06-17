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

    @GetMapping("/Users")
    public ResponseEntity<List<Users>> getAllUsers(){
        return new ResponseEntity<>(usersServices.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/Users/{id}")
    public ResponseEntity<Optional<Users>> getUsersById(@PathVariable Integer id){
        return new ResponseEntity<>(usersServices.getUserById(id), HttpStatus.OK);
    }
}
