package com.kelompok5.secondhand.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kelompok5.secondhand.utils.StatusProductEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

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
    private Integer hargaProduct;

    @Column
    private String deskripsiProduct;



    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private Users users;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="katgoriId")
    private Kategori kategori;


    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "product")
    private Wishlist wishlist;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private StatusProductEnum statusProduct= StatusProductEnum.DIBUAT;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ImageProduct> imageProduct;
}
