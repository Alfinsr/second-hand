package com.kelompok5.secondhand.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "notifikasi")
public class Notifikasi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNotifikasi;

    @Column
    private String title;

    @Column
    private Integer hargaTawar;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private Users users;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productId")
    private Product product;

    @CreationTimestamp
    private LocalDateTime creaDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;

}
