package com.farm.prj.model;

import com.farm.prj.dto.VaccinDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "animal")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private LocalDate dateNaissance;
    private String race;
    private Double poids;
    private String observations;

    @Enumerated(EnumType.STRING)
    private TypeAnimal typeAnimal;

    private String numeroBoucle;

    @Enumerated(EnumType.STRING)
    private Sexe sexe;

    private LocalDate dateEntreeFerme = LocalDate.now();
    private LocalDate dateSortie;
    private String motifSortie;

    private Long mereId;
    private Long pereId;
    private LocalDate dateDerniereMiseBas;
    private LocalDate dateProchaineMiseBas;
    private Integer nombrePortees = 0;

    private String groupeTraitement;
    private String statut = "VIVANT";

    
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ferme_id", nullable = false)
    @JsonBackReference
    private Ferme ferme;

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Vaccin> vaccins = new ArrayList<>();

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Traitement> traitements = new ArrayList<>();

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Pesee> pesees = new ArrayList<>();

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Evenement> evenements = new ArrayList<>();

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

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
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

	public TypeAnimal getTypeAnimal() {
		return typeAnimal;
	}

	public void setTypeAnimal(TypeAnimal typeAnimal) {
		this.typeAnimal = typeAnimal;
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

	public LocalDate getDateEntreeFerme() {
		return dateEntreeFerme;
	}

	public void setDateEntreeFerme(LocalDate dateEntreeFerme) {
		this.dateEntreeFerme = dateEntreeFerme;
	}

	public LocalDate getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(LocalDate dateSortie) {
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

	public LocalDate getDateDerniereMiseBas() {
		return dateDerniereMiseBas;
	}

	public void setDateDerniereMiseBas(LocalDate dateDerniereMiseBas) {
		this.dateDerniereMiseBas = dateDerniereMiseBas;
	}

	public LocalDate getDateProchaineMiseBas() {
		return dateProchaineMiseBas;
	}

	public void setDateProchaineMiseBas(LocalDate dateProchaineMiseBas) {
		this.dateProchaineMiseBas = dateProchaineMiseBas;
	}

	public Integer getNombrePortees() {
		return nombrePortees;
	}

	public void setNombrePortees(Integer nombrePortees) {
		this.nombrePortees = nombrePortees;
	}

	public String getGroupeTraitement() {
		return groupeTraitement;
	}

	public void setGroupeTraitement(String groupeTraitement) {
		this.groupeTraitement = groupeTraitement;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Ferme getFerme() {
		return ferme;
	}

	public void setFerme(Ferme ferme) {
		this.ferme = ferme;
	}

	public List<Vaccin> getVaccins() {
		return vaccins;
	}

	public void setVaccins(List<Vaccin> vaccins) {
		this.vaccins = vaccins;
	}

	public List<Traitement> getTraitements() {
		return traitements;
	}

	public void setTraitements(List<Traitement> traitements) {
		this.traitements = traitements;
	}

	public List<Pesee> getPesees() {
		return pesees;
	}

	public void setPesees(List<Pesee> pesees) {
		this.pesees = pesees;
	}

	public List<Evenement> getEvenements() {
		return evenements;
	}

	public void setEvenements(List<Evenement> evenements) {
		this.evenements = evenements;
	}
    
    
    
}
