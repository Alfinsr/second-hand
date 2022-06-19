package com.kelompok5.secondhand.entity;
import com.kelompok5.secondhand.utils.StatusProductEnum;
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
    private Integer hargaProduct;

    @Column
    private String deskripsiProduct;

    @Column
    private String fotoProduct;

    @Column
    private Integer idKategori;

    @Column
    private Integer idUser;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private StatusProductEnum statusProduct= StatusProductEnum.DIBUAT;
}
