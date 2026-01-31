package com.farm.prj.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "machine")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column
    private String type;

    @ManyToOne
    @JoinColumn(name = "ferme_id")
    private Ferme ferme;
}
