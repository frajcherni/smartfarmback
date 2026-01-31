package com.farm.prj.model;


import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "evenement")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_evenement")
    private LocalDate dateEvenement;

    @Column(name = "type_evenement")
    private String typeEvenement; // "MISE_BAS", "SAILLIE", "VENTE", "MORT", "ACHAT", etc.

    @Column(name = "description", length = 500)
    private String description;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    @JsonBackReference
    private Animal animal;
}