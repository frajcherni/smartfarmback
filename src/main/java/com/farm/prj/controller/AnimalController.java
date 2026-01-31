package com.farm.prj.controller;

import com.farm.prj.dto.AnimalDTO;
import com.farm.prj.dto.AnimalRequestDTO; // On va créer ce DTO pour les créations/modifs
import com.farm.prj.model.Animal;
import com.farm.prj.model.Ferme;
import com.farm.prj.model.TypeAnimal;
import com.farm.prj.service.AnimalService;
import com.farm.prj.service.FermeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import com.farm.prj.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    private final AnimalService animalService;
    private final FermeService fermeService;
    private final JwtUtil jwtUtil;

    // Injection par constructeur (meilleure pratique, @Autowired inutile)
    public AnimalController(AnimalService animalService, FermeService fermeService, JwtUtil jwtUtil) {
        this.animalService = animalService;
        this.fermeService = fermeService;
        this.jwtUtil = jwtUtil;
    }

    // GET : tous les animaux (en DTO pour éviter les cycles JSON)
    @GetMapping
    public ResponseEntity<List<AnimalDTO>> getAllAnimaux(@RequestHeader("Authorization") String token) {
        String jwt = token.substring(7);
        Long userId = jwtUtil.extractUserId(jwt);

        List<AnimalDTO> animaux = animalService.getAnimalsByUserId(userId)
                .stream()
                .map(AnimalDTO::new)
                .toList();
        return ResponseEntity.ok(animaux);
    }

    // GET : un animal par ID (en DTO)
    @GetMapping("/{id}")
    public ResponseEntity<AnimalDTO> getAnimalById(@PathVariable Long id) {
        Animal animal = animalService.getAnimalById(id)
                .orElseThrow(() -> new RuntimeException("Animal non trouvé avec l'id : " + id));
        return ResponseEntity.ok(new AnimalDTO(animal));
    }

    // GET : tous les animaux d'une ferme
    @GetMapping("/ferme/{fermeId}")
    public ResponseEntity<List<AnimalDTO>> getAnimalsByFerme(@PathVariable Long fermeId) {
        // Optionnel : vérifier que la ferme existe
        fermeService.getFermeById(fermeId)
                .orElseThrow(() -> new RuntimeException("Ferme non trouvée"));

        List<AnimalDTO> animaux = animalService.getAnimalsByFermeId(fermeId)
                .stream()
                .map(AnimalDTO::new)
                .toList();

        return ResponseEntity.ok(animaux);
    }

    // POST : créer un animal
    @PostMapping
    public ResponseEntity<AnimalDTO> createAnimal(@Valid @RequestBody AnimalRequestDTO request) {
        Ferme ferme = fermeService.getFermeById(request.getFermeId())
                .orElseThrow(() -> new RuntimeException("Ferme non trouvée"));

        Animal animal = request.toEntity();
        animal.setFerme(ferme); // Tu gardes ça

        Animal saved = animalService.saveAnimal(animal);
        return new ResponseEntity<>(new AnimalDTO(saved), HttpStatus.CREATED);
    }

    // PUT : mise à jour complète d'un animal
    @PutMapping("/{id}")
    public ResponseEntity<AnimalDTO> updateAnimal(@PathVariable Long id,
            @Valid @RequestBody AnimalRequestDTO request) {
        Animal animal = animalService.getAnimalById(id)
                .orElseThrow(() -> new RuntimeException("Animal non trouvé"));

        // Mise à jour des champs simples
        request.updateEntity(animal);

        // Gestion de la ferme si changée
        if (request.getFermeId() != null) {
            Ferme ferme = fermeService.getFermeById(request.getFermeId())
                    .orElseThrow(() -> new RuntimeException("Ferme non trouvée"));
            animal.setFerme(ferme);
        }

        Animal updated = animalService.saveAnimal(animal);
        return ResponseEntity.ok(new AnimalDTO(updated));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Long id) {
        animalService.deleteAnimal(id);
        return ResponseEntity.noContent().build();
    }

    // Liste des types d'animaux (utile pour les formulaires)
    @GetMapping("/types")
    public ResponseEntity<TypeAnimal[]> getTypeAnimaux() {
        return ResponseEntity.ok(TypeAnimal.values());
    }
}