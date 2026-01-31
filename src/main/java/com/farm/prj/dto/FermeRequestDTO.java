package com.farm.prj.dto;

import com.farm.prj.model.Ferme;
import jakarta.validation.constraints.NotBlank;

public class FermeRequestDTO {

    @NotBlank(message = "Le nom de la ferme est obligatoire")
    private String nom;
    private String localisation;
    private Double superficie;
    private String typeExploitation;
    private String numeroExploitation;

    // Constructeurs
    public FermeRequestDTO() {}

    public FermeRequestDTO(String nom, String localisation, Double superficie, String typeExploitation, String numeroExploitation) {
        this.nom = nom;
        this.localisation = localisation;
        this.superficie = superficie;
        this.typeExploitation = typeExploitation;
        this.numeroExploitation = numeroExploitation;
    }

    // Getters / Setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getLocalisation() { return localisation; }
    public void setLocalisation(String localisation) { this.localisation = localisation; }

    public Double getSuperficie() { return superficie; }
    public void setSuperficie(Double superficie) { this.superficie = superficie; }

    public String getTypeExploitation() { return typeExploitation; }
    public void setTypeExploitation(String typeExploitation) { this.typeExploitation = typeExploitation; }

    public String getNumeroExploitation() { return numeroExploitation; }
    public void setNumeroExploitation(String numeroExploitation) { this.numeroExploitation = numeroExploitation; }

    // Convertir DTO en entity
    public Ferme toEntity() {
        Ferme ferme = new Ferme();
        ferme.setNom(nom);
        ferme.setLocalisation(localisation);
        ferme.setSuperficie(superficie);
        ferme.setTypeExploitation(typeExploitation);
        ferme.setNumeroExploitation(numeroExploitation);
        return ferme;
    }

    // Mettre à jour une entity existante
    public void updateEntity(Ferme ferme) {
        ferme.setNom(nom);
        ferme.setLocalisation(localisation);
        if (superficie != null) ferme.setSuperficie(superficie);
        ferme.setTypeExploitation(typeExploitation);
        ferme.setNumeroExploitation(numeroExploitation);
    }
}
