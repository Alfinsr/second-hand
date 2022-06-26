package com.kelompok5.secondhand.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;

    @Column
    private String fullName;

    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String profileFoto;

    @Column
    private String noWa;

    @Column
    private String alamat;

    @Column
    private String kota;

    @ManyToMany(fetch = FetchType.EAGER )
    private Collection<Role> roles = new ArrayList<>();

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Users> users;
}
