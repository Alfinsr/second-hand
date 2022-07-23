package com.kelompok5.secondhand.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kelompok5.secondhand.utils.StatusProductEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduct;

    @Column
    private String namaProduct;

    @Column
    private Integer hargaProduct;

    @Column
    private String deskripsiProduct;

    @CreationTimestamp
    private LocalDateTime creaDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    @ManyToOne()
    @JoinColumn(name = "userId")
    private Users users;

    @ManyToOne()
    @JoinColumn(name="katgoriId")
    private Kategori kategori;


    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "product")
    private Transaksi transaksi;

    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY,
            mappedBy = "product")
    private Wishlist wishlist;



    @Column
    @Enumerated(EnumType.ORDINAL)
    private StatusProductEnum statusProduct= StatusProductEnum.DIBUAT;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<ImageProduct> imageProduct;
}
