package com.kelompok5.secondhand.services;

import com.kelompok5.secondhand.entity.Users;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UsersServices {

    Users postUsers(Users body);
    List<Users> getAllUsers();
    Optional<Users> getUserById(Integer id);
    Users updateUsers(Users body, Integer id);
    String deleteUser(Integer id);
}
