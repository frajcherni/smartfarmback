package com.farm.prj.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "equipement")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "ferme_id")
    private Ferme ferme;
}
