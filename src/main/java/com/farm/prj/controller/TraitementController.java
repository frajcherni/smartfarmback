package com.farm.prj.controller;

import com.farm.prj.model.Traitement;
import com.farm.prj.service.TraitementService;
import com.farm.prj.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/traitements")
public class TraitementController {

    private final TraitementService traitementService;
    private final JwtUtil jwtUtil;

    public TraitementController(TraitementService traitementService, JwtUtil jwtUtil) {
        this.traitementService = traitementService;
        this.jwtUtil = jwtUtil;
    }

    // GET : tous les traitements
    @GetMapping
    public List<Traitement> getAllTraitements(@RequestHeader(name = "Authorization", required = false) String token) {
        if (token != null && token.startsWith("Bearer ")) {
            String jwt = token.substring(7);
            Long userId = jwtUtil.extractUserId(jwt);
            return traitementService.getTraitementsByUserId(userId);
        }
        // Fallback or legacy (or you could throw 401)
        return traitementService.getAllTraitements();
    }

    // GET : traitement par ID
    @GetMapping("/{id}")
    public Traitement getTraitementById(@PathVariable Long id) {
        return traitementService.getTraitementById(id)
                .orElseThrow(() -> new RuntimeException("Traitement non trouvé avec id : " + id));
    }

    // GET : tous les traitements d'un animal
    @GetMapping("/animal/{animalId}")
    public List<Traitement> getTraitementsByAnimal(@PathVariable Long animalId) {
        return traitementService.getTraitementsByAnimalId(animalId);
    }

    // POST : ajouter un traitement
    @PostMapping
    public Traitement createTraitement(@RequestBody Traitement traitement) {
        return traitementService.saveTraitement(traitement);
    }

    // PUT : mettre à jour un traitement
    @PutMapping("/{id}")
    public Traitement updateTraitement(@PathVariable Long id, @RequestBody Traitement traitementDetails) {
        Traitement traitement = traitementService.getTraitementById(id)
                .orElseThrow(() -> new RuntimeException("Traitement non trouvé avec id : " + id));

        traitement.setDateTraitement(traitementDetails.getDateTraitement());
        traitement.setProchainTraitement(traitementDetails.getProchainTraitement());
        traitement.setNomMedicament(traitementDetails.getNomMedicament());
        traitement.setDosage(traitementDetails.getDosage());
        traitement.setDureeRetraitJours(traitementDetails.getDureeRetraitJours());
        traitement.setObservations(traitementDetails.getObservations());
        traitement.setAnimal(traitementDetails.getAnimal());

        return traitementService.saveTraitement(traitement);
    }

    // DELETE : supprimer un traitement
    @DeleteMapping("/{id}")
    public void deleteTraitement(@PathVariable Long id) {
        traitementService.deleteTraitement(id);
    }
}
