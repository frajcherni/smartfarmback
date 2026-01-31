package com.farm.prj.dto;

import com.farm.prj.model.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AnimalRequestDTO {

    @NotBlank(message = "Le nom est obligatoire")
    private String nom;

    private String dateNaissance;
    private String race;
    private Double poids;
    private String observations;
    private String numeroBoucle;

    @NotNull(message = "Le sexe est obligatoire")
    private Sexe sexe;

    @NotNull(message = "Le type d'animal est obligatoire")
    private TypeAnimal typeAnimal;

    private String dateEntreeFerme;
    private String statut = "VIVANT";
    private String dateSortie;
    private String motifSortie;

    private Long mereId;
    private Long pereId;
    private Integer nombrePortees = 0;

    // LE CHAMP QUI MANQUAIT VRAIMENT
    private Long fermeId;
    private List<VaccinDTO> vaccins = new ArrayList<>();
    private List<TraitementDTO> traitements = new ArrayList<>();

    public List<VaccinDTO> getVaccins() {
        return vaccins;
    }

    public void setVaccins(List<VaccinDTO> vaccins) {
        this.vaccins = vaccins != null ? vaccins : new ArrayList<>();
    }

    public List<TraitementDTO> getTraitements() {
        return traitements;
    }

    public void setTraitements(List<TraitementDTO> traitements) {
        this.traitements = traitements != null ? traitements : new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Double getPoids() {
        return poids;
    }

    public void setPoids(Double poids) {
        this.poids = poids;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getNumeroBoucle() {
        return numeroBoucle;
    }

    public void setNumeroBoucle(String numeroBoucle) {
        this.numeroBoucle = numeroBoucle;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public TypeAnimal getTypeAnimal() {
        return typeAnimal;
    }

    public void setTypeAnimal(TypeAnimal typeAnimal) {
        this.typeAnimal = typeAnimal;
    }

    public String getDateEntreeFerme() {
        return dateEntreeFerme;
    }

    public void setDateEntreeFerme(String dateEntreeFerme) {
        this.dateEntreeFerme = dateEntreeFerme;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(String dateSortie) {
        this.dateSortie = dateSortie;
    }

    public String getMotifSortie() {
        return motifSortie;
    }

    public void setMotifSortie(String motifSortie) {
        this.motifSortie = motifSortie;
    }

    public Long getMereId() {
        return mereId;
    }

    public void setMereId(Long mereId) {
        this.mereId = mereId;
    }

    public Long getPereId() {
        return pereId;
    }

    public void setPereId(Long pereId) {
        this.pereId = pereId;
    }

    public Integer getNombrePortees() {
        return nombrePortees;
    }

    public void setNombrePortees(Integer nombrePortees) {
        this.nombrePortees = nombrePortees;
    }

    // LE GETTER QUI MANQUAIT !!!
    public Long getFermeId() {
        return fermeId;
    }

    public void setFermeId(Long fermeId) {
        this.fermeId = fermeId;
    }

    // Convertit le DTO en entité Animal (POUR POST)
    public Animal toEntity() {
        Animal animal = new Animal();
        animal.getVaccins().clear();
        animal.getTraitements().clear();
        animal.setNom(this.nom);
        try {
            if (this.dateNaissance != null && !this.dateNaissance.isEmpty()) {
                animal.setDateNaissance(LocalDate.parse(this.dateNaissance));
            }
        } catch (Exception e) {
        }

        animal.setRace(this.race);
        animal.setPoids(this.poids);
        animal.setObservations(this.observations);
        animal.setNumeroBoucle(this.numeroBoucle);
        animal.setSexe(this.sexe);
        animal.setTypeAnimal(this.typeAnimal);

        try {
            if (this.dateEntreeFerme != null && !this.dateEntreeFerme.isEmpty()) {
                animal.setDateEntreeFerme(LocalDate.parse(this.dateEntreeFerme));
            } else {
                animal.setDateEntreeFerme(LocalDate.now());
            }
        } catch (Exception e) {
            animal.setDateEntreeFerme(LocalDate.now());
        }

        animal.setStatut(this.statut);

        try {
            if (this.dateSortie != null && !this.dateSortie.isEmpty()) {
                animal.setDateSortie(LocalDate.parse(this.dateSortie));
            }
        } catch (Exception e) {
        }

        animal.setMotifSortie(this.motifSortie);
        animal.setMereId(this.mereId);
        animal.setPereId(this.pereId);
        animal.setNombrePortees(this.nombrePortees);
        if (this.vaccins != null) {
            for (VaccinDTO vDto : this.vaccins) {
                if (vDto.getType() != null && !vDto.getType().trim().isEmpty()) {
                    Vaccin vaccin = new Vaccin();
                    vaccin.setType(vDto.getType());
                    vaccin.setDate(vDto.getDate());
                    vaccin.setProchainVaccin(vDto.getProchainVaccin());
                    vaccin.setAnimal(animal);
                    animal.getVaccins().add(vaccin);
                }
            }
        }
        if (this.traitements != null) {
            for (TraitementDTO tDto : this.traitements) {
                if (tDto.getNomMedicament() != null && !tDto.getNomMedicament().trim().isEmpty()) {
                    Traitement traitement = new Traitement();
                    traitement.setNomMedicament(tDto.getNomMedicament());
                    traitement.setDateTraitement(tDto.getDateTraitement());
                    traitement.setProchainTraitement(tDto.getProchainTraitement());
                    traitement.setDosage(tDto.getDosage());
                    traitement.setDureeRetraitJours(tDto.getDureeRetraitJours());
                    traitement.setObservations(tDto.getObservations());
                    traitement.setAnimal(animal);
                    animal.getTraitements().add(traitement);
                }
            }
        }
        return animal;
    }

    // Met à jour une entité existante (POUR PUT)
    // DANS AnimalRequestDTO.java → REMPLACE LA MÉTHODE updateEntity()
    public void updateEntity(Animal animal) {
        animal.setNom(this.nom);
        try {
            if (this.dateNaissance != null && !this.dateNaissance.isEmpty()) {
                animal.setDateNaissance(LocalDate.parse(this.dateNaissance));
            } else {
                animal.setDateNaissance(null);
            }
        } catch (Exception e) {
        }

        animal.setRace(this.race);
        animal.setPoids(this.poids);
        animal.setObservations(this.observations);
        animal.setNumeroBoucle(this.numeroBoucle);
        animal.setSexe(this.sexe);
        animal.setTypeAnimal(this.typeAnimal);

        try {
            if (this.dateEntreeFerme != null && !this.dateEntreeFerme.isEmpty()) {
                animal.setDateEntreeFerme(LocalDate.parse(this.dateEntreeFerme));
            }
        } catch (Exception e) {
        }

        animal.setStatut(this.statut != null ? this.statut : "VIVANT");

        try {
            if (this.dateSortie != null && !this.dateSortie.isEmpty()) {
                animal.setDateSortie(LocalDate.parse(this.dateSortie));
            } else {
                animal.setDateSortie(null);
            }
        } catch (Exception e) {
        }

        animal.setMotifSortie(this.motifSortie);
        animal.setMereId(this.mereId);
        animal.setPereId(this.pereId);
        animal.setNombrePortees(this.nombrePortees != null ? this.nombrePortees : 0);

        animal.getVaccins().clear();
        animal.getTraitements().clear();

        if (this.vaccins != null) {
            for (VaccinDTO vDto : this.vaccins) {
                if (vDto.getType() != null && !vDto.getType().trim().isEmpty()) {
                    Vaccin vaccin = new Vaccin();
                    vaccin.setType(vDto.getType());
                    vaccin.setDate(vDto.getDate());
                    vaccin.setProchainVaccin(vDto.getProchainVaccin());
                    vaccin.setAnimal(animal);
                    animal.getVaccins().add(vaccin);
                }
            }
        }

        if (this.traitements != null) {
            for (TraitementDTO tDto : this.traitements) {
                if (tDto.getNomMedicament() != null && !tDto.getNomMedicament().trim().isEmpty()) {
                    Traitement traitement = new Traitement();
                    traitement.setNomMedicament(tDto.getNomMedicament());
                    traitement.setDateTraitement(tDto.getDateTraitement());
                    traitement.setProchainTraitement(tDto.getProchainTraitement());
                    traitement.setDosage(tDto.getDosage());
                    traitement.setDureeRetraitJours(tDto.getDureeRetraitJours());
                    traitement.setObservations(tDto.getObservations());
                    traitement.setAnimal(animal);
                    animal.getTraitements().add(traitement);
                }
            }
        }
    }

}