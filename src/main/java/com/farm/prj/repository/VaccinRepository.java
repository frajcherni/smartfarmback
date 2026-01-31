package com.farm.prj.repository;

import com.farm.prj.model.Vaccin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccinRepository extends JpaRepository<Vaccin, Long> {

    // Lister tous les vaccins d'un animal
    List<Vaccin> findByAnimalId(Long animalId);

    List<Vaccin> findByAnimalFermeUserId(Long userId);
}
