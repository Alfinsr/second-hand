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

    @OneToOne()
    @JoinColumn(name = "tawaranId")
    private Tawaran tawaran;

 

    @CreationTimestamp
    private LocalDateTime creaDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;

}
