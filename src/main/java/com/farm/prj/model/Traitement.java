package com.farm.prj.model;

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
@Table(name = "traitement")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Traitement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_traitement")
    private String dateTraitement;

    @Column(name = "nom_medicament")
    private String nomMedicament;

    @Column(name = "dosage")
    private String dosage;

    @Column(name = "duree_retrait_jours")
    private Integer dureeRetraitJours; // Très important pour viande/lait

    @Column(name = "observations")
    private String observations;

    @Column(name = "prochain_traitement")
    private String prochainTraitement;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    @JsonBackReference
    private Animal animal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateTraitement() {
        return dateTraitement;
    }

    public void setDateTraitement(String dateTraitement) {
        this.dateTraitement = dateTraitement;
    }

    public String getProchainTraitement() {
        return prochainTraitement;
    }

    public void setProchainTraitement(String prochainTraitement) {
        this.prochainTraitement = prochainTraitement;
    }

    public String getNomMedicament() {
        return nomMedicament;
    }

    public void setNomMedicament(String nomMedicament) {
        this.nomMedicament = nomMedicament;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public Integer getDureeRetraitJours() {
        return dureeRetraitJours;
    }

    public void setDureeRetraitJours(Integer dureeRetraitJours) {
        this.dureeRetraitJours = dureeRetraitJours;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}