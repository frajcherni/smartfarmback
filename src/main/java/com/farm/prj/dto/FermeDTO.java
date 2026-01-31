package com.farm.prj.dto;

import com.farm.prj.model.Ferme;
import lombok.Data;

public class FermeDTO {
    private Long id;
    private String nom;
    private String localisation;
    private Double superficie;
    private String typeExploitation;
    private String numeroExploitation;

    public FermeDTO(Ferme ferme) {
        this.id = ferme.getId();
        this.nom = ferme.getNom();
        this.localisation = ferme.getLocalisation();
        this.superficie = ferme.getSuperficie();
        this.typeExploitation = ferme.getTypeExploitation();
        this.numeroExploitation = ferme.getNumeroExploitation();
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


}
