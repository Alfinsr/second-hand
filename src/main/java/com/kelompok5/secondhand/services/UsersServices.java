package com.kelompok5.secondhand.services;

import com.kelompok5.secondhand.dto.UsersDto;
import com.kelompok5.secondhand.entity.Users;
import com.kelompok5.secondhand.result.Result;

import org.springframework.stereotype.Component;



@Component
public interface UsersServices {

    Result  postUsers(Users body);

    Result getUserById(String username);
    Result updateUsers(UsersDto body, String username);
    Result deleteUser(Integer id);
    Result updatePassword(UsersDto body, String username);
    Users findByUsername(String username);

}
