package com.farm.prj.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vaccin")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vaccin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type; // Ex: "الجدري + لحمى القلاعية"

    @Column(name = "date_vaccin")
    private String date; // ou LocalDate si tu veux

    @Column(name = "prochain_vaccin")
    private String prochainVaccin;

    // Relation ManyToOne avec Animal
    @ManyToOne
    @JoinColumn(name = "animal_id")
    @JsonBackReference
    private Animal animal;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getProchainVaccin() {
		return prochainVaccin;
	}

	public void setProchainVaccin(String prochainVaccin) {
		this.prochainVaccin = prochainVaccin;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
    
}