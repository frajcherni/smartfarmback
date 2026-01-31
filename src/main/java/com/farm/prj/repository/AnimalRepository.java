package com.farm.prj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farm.prj.model.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findByFermeId(Long fermeId);

    List<Animal> findByFermeUserId(Long userId);
}
