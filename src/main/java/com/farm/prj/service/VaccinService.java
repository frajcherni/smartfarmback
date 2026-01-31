package com.farm.prj.service;

import com.farm.prj.model.Vaccin;
import com.farm.prj.repository.VaccinRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VaccinService {

    private final VaccinRepository vaccinRepository;

    public VaccinService(VaccinRepository vaccinRepository) {
        this.vaccinRepository = vaccinRepository;
    }

    public Vaccin saveVaccin(Vaccin vaccin) {
        return vaccinRepository.save(vaccin);
    }

    public List<Vaccin> getAllVaccins() {
        return vaccinRepository.findAll();
    }

    public Optional<Vaccin> getVaccinById(Long id) {
        return vaccinRepository.findById(id);
    }

    public List<Vaccin> getVaccinsByAnimalId(Long animalId) {
        return vaccinRepository.findByAnimalId(animalId);
    }

    public List<Vaccin> getVaccinsByUserId(Long userId) {
        return vaccinRepository.findByAnimalFermeUserId(userId);
    }

    public void deleteVaccin(Long id) {
        vaccinRepository.deleteById(id);
    }
}
