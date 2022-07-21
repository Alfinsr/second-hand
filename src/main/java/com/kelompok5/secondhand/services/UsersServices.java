package com.kelompok5.secondhand.services;

import com.kelompok5.secondhand.entity.Users;
import com.kelompok5.secondhand.result.Result;

import org.springframework.stereotype.Component;



@Component
public interface UsersServices {

    Result  postUsers(Users body);

    Result getUserById(String username);
    Result updateUsers(Users body, String username);
    Result deleteUser(Integer id);
    Users findByUsername(String username);

}
