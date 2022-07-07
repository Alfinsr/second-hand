package com.kelompok5.secondhand.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Wishlist implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer wishlistId;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private Users users;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productId")
    private Product product;
}
