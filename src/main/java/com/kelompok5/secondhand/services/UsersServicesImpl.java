package com.kelompok5.secondhand.services;


import com.kelompok5.secondhand.entity.Users;
import com.kelompok5.secondhand.repository.UsersRepository;
import com.kelompok5.secondhand.result.Result;
import com.kelompok5.secondhand.result.SuccessDataResult;
import com.kelompok5.secondhand.result.SuccessResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
 @Slf4j
public class UsersServicesImpl implements UsersServices, UserDetailsService {

    @Autowired
    private final UsersRepository usersRepository;

    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findByUsername(username);
        if(user != null){
            log.info("User found in the database : {}", username);
        }else{
            log.error("User not found in the database");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleName())));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public Result postUsers(Users body) {
        Users usersExists =   usersRepository.findByUsername(body.getUsername());
        if(usersExists != null){
            throw  new IllegalArgumentException(String.format("User with username '%s' already exists", body.getUsername()));
        }
        String encodePassword = bCryptPasswordEncoder.encode(body.getPassword());
        body.setPassword(encodePassword);
        usersRepository.save(body);
        return new SuccessDataResult(body, "Success Register User");

    }

    @Override
    public Result getAllUsers() {
        List<Users> users = usersRepository.findAll();
        return new SuccessDataResult(users, "Success get all users");
    }

    @Override
    public Result getUserById(Integer id) {
     Optional<Users> users=    usersRepository.findById(id);
     return  new SuccessDataResult(users,"Success Get User By Id");
    }

    @Override
    public Result updateUsers(Users body,String username) {
        Users users = usersRepository.findByUsername(username);
        users.setFullName(body.getFullName());
        users.setPassword(bCryptPasswordEncoder.encode(body.getPassword()));
        users.setAlamat(body.getAlamat());
        users.setEmail(body.getEmail());
        users.setKota(body.getKota());
        users.setNoWa(body.getNoWa());
        users.setProfileFoto(body.getProfileFoto());
        usersRepository.save(users);
        return new SuccessResult("success update profile");
    }

    @Override
    public Result deleteUser(Integer id) {
         usersRepository.deleteById(id);
         return new SuccessResult("Sucess Delete User");
    }
}
