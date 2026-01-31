package com.farm.prj.service;

import com.farm.prj.model.Animal;
import com.farm.prj.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Optional<Animal> getAnimalById(Long id) {
        return animalRepository.findById(id);
    }

    public List<Animal> getAnimalsByFermeId(Long fermeId) {
        return animalRepository.findByFermeId(fermeId);
    }

    public List<Animal> getAnimalsByUserId(Long userId) {
        return animalRepository.findByFermeUserId(userId);
    }

    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }
}
