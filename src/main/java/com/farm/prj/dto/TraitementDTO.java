package com.farm.prj.dto;

import com.farm.prj.model.Traitement;

public class TraitementDTO {
    private Long id;
    private String nomMedicament;
    private String dateTraitement;
    private String prochainTraitement;
    private String dosage;
    private Integer dureeRetraitJours;
    private String observations;

    // Constructeur vide pour Jackson
    public TraitementDTO() {
    }

    // Constructeur pour les GET (depuis entité)
    public TraitementDTO(Traitement traitement) {
        this.id = traitement.getId();
        this.nomMedicament = traitement.getNomMedicament();
        this.dateTraitement = traitement.getDateTraitement();
        this.prochainTraitement = traitement.getProchainTraitement();
        this.dosage = traitement.getDosage();
        this.dureeRetraitJours = traitement.getDureeRetraitJours();
        this.observations = traitement.getObservations();
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomMedicament() {
        return nomMedicament;
    }

    public void setNomMedicament(String nomMedicament) {
        this.nomMedicament = nomMedicament;
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
}
