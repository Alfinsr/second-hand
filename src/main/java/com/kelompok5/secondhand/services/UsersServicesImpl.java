package com.kelompok5.secondhand.services;


import com.kelompok5.secondhand.dto.UsersDto;
import com.kelompok5.secondhand.entity.Users;
import com.kelompok5.secondhand.repository.UsersRepository;
import com.kelompok5.secondhand.result.ErrorResult;
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
import java.util.Map;


@Service
@RequiredArgsConstructor
 @Slf4j
public class UsersServicesImpl implements UsersServices, UserDetailsService {

    @Autowired
    private final UsersRepository usersRepository;

    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private final CloudinaryStorageService cloudinaryStorageService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = usersRepository.findByEmail(email);
        if(user != null){
            log.info("User found in the database : {}", email);
        }else{
            log.error("User not found in the database");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        assert user != null;
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleName())));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public Result postUsers(Users body) {
        Users usersExists =   usersRepository.findByUsername(body.getUsername());
       try {
           if(usersExists != null){
               throw  new IllegalArgumentException(String.format("User with username '%s' already exists", body.getUsername()));
           }
           String encodePassword = bCryptPasswordEncoder.encode(body.getPassword());
           body.setPassword(encodePassword);
           usersRepository.save(body);
           return new SuccessDataResult<>(body, "Success Register User");
       }catch (Exception e){
           return new ErrorResult("User sudah terdaftar");
       }

    }



    @Override
    public Result getUserById(String username) {
     Users users = usersRepository.findByUsername(username);
     return  new SuccessDataResult<>(users,"Success Get User By Id");
    }

    @Override
    public Result updateUsers(UsersDto body, String username) {
        Users users = usersRepository.findByUsername(username);
        if(body.getProfileFoto() == null){
        users.setFullName(body.getFullName());

        users.setAlamat(body.getAlamat());

        users.setKota(body.getKota());
        users.setNoWa(body.getNoWa());
        usersRepository.save(users);
        return new SuccessResult("success update profile");
        }else{

            Map<?, ?> uploadImage = (Map<?, ?>) cloudinaryStorageService.upload(body.getProfileFoto()).getData();

            users.setKota(body.getKota());
            users.setFullName(body.getFullName());
            users.setAlamat(body.getAlamat());
            users.setNoWa(body.getNoWa());
            users.setProfileFoto(uploadImage.get("url").toString());
            usersRepository.save(users);
            return new SuccessResult("success update profile");
        }
    }

    @Override
    public Result deleteUser(Integer id) {
         usersRepository.deleteById(id);
         return new SuccessResult("Sucess Delete User");
    }

    @Override
    public Users findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }

    @Override
    public Result updatePassword(UsersDto body, String username) {
        Users users = usersRepository.findByUsername(username);
        users.setPassword(bCryptPasswordEncoder.encode(body.getPassword()));
        usersRepository.save(users);
        return new SuccessResult("Success update password user");
    }
}
