package com.kelompok5.secondhand.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "kategori")
public class Kategori {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idKategori;

    @Column(nullable = false, length = 10)
    private String namaKategori;

    @JsonBackReference
    @OneToMany(mappedBy = "kategori")
    private List<Product> product;

}
