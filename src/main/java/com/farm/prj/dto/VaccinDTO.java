// com.farm.prj.dto.VaccinDTO.java  ← garde exactement ça
package com.farm.prj.dto;

import com.farm.prj.model.Vaccin;

public class VaccinDTO {
    private Long id;
    private String type;
    private String date;           // String car Angular envoie "2025-12-02"
    private String prochainVaccin;

    // Constructeur pour les GET (depuis entité)
    public VaccinDTO(Vaccin vaccin) {
        this.id = vaccin.getId();
        this.type = vaccin.getType();
        this.date = vaccin.getDate() != null ? vaccin.getDate().toString() : null;
        this.prochainVaccin = vaccin.getProchainVaccin() != null ? vaccin.getProchainVaccin().toString() : null;
    }

    // Constructeur vide pour Jackson (pour POST/PUT)
    public VaccinDTO() {}

    // Getters & Setters (tu les as déjà, parfait)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getProchainVaccin() { return prochainVaccin; }
    public void setProchainVaccin(String prochainVaccin) { this.prochainVaccin = prochainVaccin; }
}