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
@Table(name = "pesee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pesee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_pesee")
    private LocalDate datePesee;

    @Column(name = "poids_kg", nullable = false)
    private Double poidsKg;

    @Column(name = "observations")
    private String observations;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    @JsonBackReference
    private Animal animal;
}