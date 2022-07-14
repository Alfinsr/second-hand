package com.kelompok5.secondhand.entity;

import com.kelompok5.secondhand.utils.StatutsTawaranEnum;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "tawaran")
public class Tawaran {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTawaran;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private Users users;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="id_product")
    private Product product;

    @Column
    private String hargaTawar;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private StatutsTawaranEnum statusTawaran = StatutsTawaranEnum.WAITING;

}
