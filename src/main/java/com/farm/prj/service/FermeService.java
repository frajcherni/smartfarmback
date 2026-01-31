package com.farm.prj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farm.prj.model.Ferme;
import com.farm.prj.repository.FermeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FermeService {

    @Autowired
    private FermeRepository fermeRepository;

    // Récupérer toutes les fermes
    public List<Ferme> getAllFermes() {
        return fermeRepository.findAll();
    }

    public List<Ferme> getAllFermes(Long userId) {
        return fermeRepository.findByUserId(userId);
    }

    // Récupérer une ferme par id
    public Optional<Ferme> getFermeById(Long id) {
        return fermeRepository.findById(id);
    }

    // Créer ou mettre à jour une ferme
    public Ferme saveFerme(Ferme ferme) {
        return fermeRepository.save(ferme);
    }

    // Supprimer une ferme
    public void deleteFerme(Long id) {
        fermeRepository.deleteById(id);
    }
}
