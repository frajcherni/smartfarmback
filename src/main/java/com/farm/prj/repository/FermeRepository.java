package com.farm.prj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farm.prj.model.Ferme;

import java.util.List;

@Repository
public interface FermeRepository extends JpaRepository<Ferme, Long> {
    List<Ferme> findByUserId(Long userId);
}