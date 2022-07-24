package com.kelompok5.secondhand.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kelompok5.secondhand.utils.StatutsTawaranEnum;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


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

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="id_product")
    private Product product;

    @Column
    private Integer hargaTawar;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private StatutsTawaranEnum statusTawaran = StatutsTawaranEnum.WAITING;

    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY,
            mappedBy = "tawaran")
    private Notifikasi notifikasi;


    @CreationTimestamp
    private LocalDateTime creaDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;

}
