package com.kelompok5.secondhand.entity;

import com.kelompok5.secondhand.utils.StatutsTawaranEnum;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    private Integer hargaTawar;

    @Column
    @Enumerated(EnumType.STRING)
    private StatutsTawaranEnum statusTawaran = StatutsTawaranEnum.WAITING;

}
