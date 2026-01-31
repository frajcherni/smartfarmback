package com.farm.prj.controller;

import com.farm.prj.model.Vaccin;
import com.farm.prj.service.VaccinService;

import com.farm.prj.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vaccins")
public class VaccinController {

    private final VaccinService vaccinService;
    private final JwtUtil jwtUtil;

    public VaccinController(VaccinService vaccinService, JwtUtil jwtUtil) {
        this.vaccinService = vaccinService;
        this.jwtUtil = jwtUtil;
    }

    // GET : tous les vaccins
    @GetMapping
    public List<Vaccin> getAllVaccins(@RequestHeader(name = "Authorization", required = false) String token) {
        if (token != null && token.startsWith("Bearer ")) {
            String jwt = token.substring(7);
            Long userId = jwtUtil.extractUserId(jwt);
            return vaccinService.getVaccinsByUserId(userId);
        }
        return vaccinService.getAllVaccins();
    }

    // GET : vaccin par ID
    @GetMapping("/{id}")
    public Vaccin getVaccinById(@PathVariable Long id) {
        return vaccinService.getVaccinById(id)
                .orElseThrow(() -> new RuntimeException("Vaccin non trouvé avec id : " + id));
    }

    // GET : tous les vaccins d'un animal
    @GetMapping("/animal/{animalId}")
    public List<Vaccin> getVaccinsByAnimal(@PathVariable Long animalId) {
        return vaccinService.getVaccinsByAnimalId(animalId);
    }

    // POST : ajouter un vaccin
    @PostMapping
    public Vaccin createVaccin(@RequestBody Vaccin vaccin) {
        return vaccinService.saveVaccin(vaccin);
    }

    // PUT : mettre à jour un vaccin
    @PutMapping("/{id}")
    public Vaccin updateVaccin(@PathVariable Long id, @RequestBody Vaccin vaccinDetails) {
        Vaccin vaccin = vaccinService.getVaccinById(id)
                .orElseThrow(() -> new RuntimeException("Vaccin non trouvé avec id : " + id));

        vaccin.setType(vaccinDetails.getType());
        vaccin.setDate(vaccinDetails.getDate());
        vaccin.setProchainVaccin(vaccinDetails.getProchainVaccin());
        vaccin.setAnimal(vaccinDetails.getAnimal());

        return vaccinService.saveVaccin(vaccin);
    }

    // DELETE : supprimer un vaccin
    @DeleteMapping("/{id}")
    public void deleteVaccin(@PathVariable Long id) {
        vaccinService.deleteVaccin(id);
    }
}
