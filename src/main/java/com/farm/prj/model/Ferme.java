package com.farm.prj.model;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "ferme")
public class Ferme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nom;

    @Column(length = 150)
    private String localisation;

    @Column
    private Double superficie;

    @OneToMany(mappedBy = "ferme", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Animal> animaux;

    @OneToMany(mappedBy = "ferme", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Machine> machines;

    @OneToMany(mappedBy = "ferme", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Equipement> equipements;

    @Column(name = "type_exploitation")
    private String typeExploitation;

    @Column(name = "numero_exploitation")
    private String numeroExploitation;

    @Column(name = "user_id")
    private Long userId;

    // Constructeurs
    public Ferme() {
    }

    public Ferme(String nom, String localisation, Double superficie, String typeExploitation,
            String numeroExploitation) {
        this.nom = nom;
        this.localisation = localisation;
        this.superficie = superficie;
        this.typeExploitation = typeExploitation;
        this.numeroExploitation = numeroExploitation;
    }

    // Getters / Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public Double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(Double superficie) {
        this.superficie = superficie;
    }

    public List<Animal> getAnimaux() {
        return animaux;
    }

    public void setAnimaux(List<Animal> animaux) {
        this.animaux = animaux;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }

    public List<Equipement> getEquipements() {
        return equipements;
    }

    public void setEquipements(List<Equipement> equipements) {
        this.equipements = equipements;
    }

    public String getTypeExploitation() {
        return typeExploitation;
    }

    public void setTypeExploitation(String typeExploitation) {
        this.typeExploitation = typeExploitation;
    }

    public String getNumeroExploitation() {
        return numeroExploitation;
    }

    public void setNumeroExploitation(String numeroExploitation) {
        this.numeroExploitation = numeroExploitation;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
