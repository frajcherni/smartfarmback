package com.farm.prj.service;

import com.farm.prj.model.Traitement;
import com.farm.prj.repository.TraitementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TraitementService {

    private final TraitementRepository traitementRepository;

    public TraitementService(TraitementRepository traitementRepository) {
        this.traitementRepository = traitementRepository;
    }

    public Traitement saveTraitement(Traitement traitement) {
        return traitementRepository.save(traitement);
    }

    public List<Traitement> getAllTraitements() {
        return traitementRepository.findAll();
    }

    public Optional<Traitement> getTraitementById(Long id) {
        return traitementRepository.findById(id);
    }

    public List<Traitement> getTraitementsByAnimalId(Long animalId) {
        return traitementRepository.findByAnimalId(animalId);
    }

    public List<Traitement> getTraitementsByUserId(Long userId) {
        return traitementRepository.findByAnimalFermeUserId(userId);
    }

    public void deleteTraitement(Long id) {
        traitementRepository.deleteById(id);
    }
}
