package com.kelompok5.secondhand.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduct;

    @Column
    private String namaProduct;

    @Column
    private String hargaProduct;

    @Column
    private String deskripsiProduct;

    @Column
    private String fotoProduct;

    @Column
    private String idKategori;

    @Column
    private String idUser;

    @Column
    private String statusProduct;
}
