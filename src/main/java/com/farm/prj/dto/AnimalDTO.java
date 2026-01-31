package com.farm.prj.dto;

import com.farm.prj.model.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class AnimalDTO {

	private Long id;
	private String nom;
	private String dateNaissance;
	private String race;
	private Double poids;
	private String observations;
	private String numeroBoucle;
	private Sexe sexe;
	private TypeAnimal typeAnimal;
	private String statut;
	private String dateEntreeFerme;
	private String dateSortie;
	private String motifSortie;
	private Long mereId;
	private Long pereId;
	private Integer nombrePortees;

	private Long fermeId;
	private String nomFerme;

	private int nombreVaccins;
	private int nombrePesees;

	private List<VaccinDTO> vaccins;
	private List<TraitementDTO> traitements;

	// Constructeur vide pour Jackson
	public AnimalDTO() {
	}

	// Constructeur principal utilisé dans les controllers
	public AnimalDTO(Animal animal) {
		this.id = animal.getId();
		this.nom = animal.getNom();
		this.dateNaissance = animal.getDateNaissance() != null ? animal.getDateNaissance().toString() : null;
		this.race = animal.getRace();
		this.poids = animal.getPoids();
		this.observations = animal.getObservations();
		this.numeroBoucle = animal.getNumeroBoucle();
		this.sexe = animal.getSexe();
		this.typeAnimal = animal.getTypeAnimal();
		this.statut = animal.getStatut();

		this.dateEntreeFerme = animal.getDateEntreeFerme() != null ? animal.getDateEntreeFerme().toString() : null;
		this.dateSortie = animal.getDateSortie() != null ? animal.getDateSortie().toString() : null;
		this.motifSortie = animal.getMotifSortie();

		this.mereId = animal.getMereId();
		this.pereId = animal.getPereId();
		this.nombrePortees = animal.getNombrePortees();

		// Ferme
		if (animal.getFerme() != null) {
			this.fermeId = animal.getFerme().getId();
			this.nomFerme = animal.getFerme().getNom();
		}

		// Vaccins
		if (animal.getVaccins() != null) {
			this.vaccins = animal.getVaccins()
					.stream()
					.map(VaccinDTO::new)
					.toList();

			this.nombreVaccins = this.vaccins.size();
		}

		// Traitements
		if (animal.getTraitements() != null) {
			this.traitements = animal.getTraitements()
					.stream()
					.map(TraitementDTO::new)
					.toList();
		}
	}

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

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getDateEntreeFerme() {
		return dateEntreeFerme;
	}

	public void setDateEntreeFerme(String dateEntreeFerme) {
		this.dateEntreeFerme = dateEntreeFerme;
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

	public Long getFermeId() {
		return fermeId;
	}

	public void setFermeId(Long fermeId) {
		this.fermeId = fermeId;
	}

	public String getNomFerme() {
		return nomFerme;
	}

	public void setNomFerme(String nomFerme) {
		this.nomFerme = nomFerme;
	}

	public int getNombreVaccins() {
		return nombreVaccins;
	}

	public void setNombreVaccins(int nombreVaccins) {
		this.nombreVaccins = nombreVaccins;
	}

	public int getNombrePesees() {
		return nombrePesees;
	}

	public void setNombrePesees(int nombrePesees) {
		this.nombrePesees = nombrePesees;
	}

	public List<VaccinDTO> getVaccins() {
		return vaccins;
	}

	public void setVaccins(List<VaccinDTO> vaccins) {
		this.vaccins = vaccins;
	}

	public List<TraitementDTO> getTraitements() {
		return traitements;
	}

	public void setTraitements(List<TraitementDTO> traitements) {
		this.traitements = traitements;
	}

}
