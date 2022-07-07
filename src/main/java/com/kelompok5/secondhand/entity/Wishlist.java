package com.kelompok5.secondhand.entity;

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
    private Long wishlistId;

    private Long userId;

    @ManyToMany
    @JoinTable (
            name="product_wishlist",
            joinColumns = @JoinColumn(name = "wishlistId"),
            inverseJoinColumns = @JoinColumn(name = "productId")
    )
    private List<Product> products;
}
