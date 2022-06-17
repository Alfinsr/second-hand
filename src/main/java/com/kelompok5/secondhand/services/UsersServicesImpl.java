package com.kelompok5.secondhand.services;

import com.kelompok5.secondhand.entity.Users;
import com.kelompok5.secondhand.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UsersServicesImpl implements UsersServices{

    @Autowired
    private final UsersRepository usersRepository;
    @Override
    public Users postUsers(Users body) {
        return null;
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Optional<Users> getUserById(Integer id) {
        return usersRepository.findById(id);
    }

    @Override
    public Users updateUser(Users body, Integer id) {
        return null;
    }

    @Override
    public String deleteUser(Integer id) {
        return null;
    }
}
