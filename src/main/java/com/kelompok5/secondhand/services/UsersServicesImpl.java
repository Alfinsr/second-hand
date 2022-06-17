package com.kelompok5.secondhand.services;

import com.kelompok5.secondhand.entity.Product;
import com.kelompok5.secondhand.entity.Users;
import com.kelompok5.secondhand.repository.UsersRepository;
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
    public Users postUsers(Users body) {
        Users usersExists =   usersRepository.findByUsername(body.getUsername());
        if(usersExists != null){
            throw  new IllegalArgumentException(String.format("User with username '%s' already exists", body.getUsername()));
        }
        String encodePassword = bCryptPasswordEncoder.encode(body.getPassword());
        body.setPassword(encodePassword);
        usersRepository.save(body);
        return body;

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
    public Users updateUsers(Users body, Integer id) {
        Users users = usersRepository.findById(id).orElseThrow();
        users.setFullName(body.getFullName());
        return usersRepository.save(users);
    }

    @Override
    public String deleteUser(Integer id) {
         usersRepository.deleteById(id);
         return "user telah dihapus";
    }
}
