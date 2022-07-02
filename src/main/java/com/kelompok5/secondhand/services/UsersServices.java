package com.kelompok5.secondhand.services;

import com.kelompok5.secondhand.entity.Users;
import com.kelompok5.secondhand.result.Result;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UsersServices {

    Result  postUsers(Users body);
    Result getAllUsers();
    Result getUserById(Integer id);
    Result updateUsers(Users body, String username);
    Result deleteUser(Integer id);
}
