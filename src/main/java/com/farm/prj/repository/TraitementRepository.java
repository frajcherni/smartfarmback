package com.farm.prj.repository;

import com.farm.prj.model.Traitement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TraitementRepository extends JpaRepository<Traitement, Long> {
    List<Traitement> findByAnimalId(Long animalId);

    List<Traitement> findByAnimalFermeUserId(Long userId);
}
