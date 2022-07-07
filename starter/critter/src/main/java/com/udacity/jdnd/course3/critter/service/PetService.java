package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.entities.Pet;
import com.udacity.jdnd.course3.critter.exception.PetNotFoundException;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PetService {

  private final PetRepository petRepository;

  public PetService(PetRepository petRepository) {
    this.petRepository = petRepository;
  }

  public Pet save(Pet pet) {
    return petRepository.save(pet);
  }

  public Pet getPetById(Long id) {
    Optional<Pet> pet = petRepository.findById(id);
    return pet.orElseThrow(PetNotFoundException::new);
  }

  public List<Pet> getAllPets() {
    return petRepository.findAll();
  }

  public List<Pet> getPetsByCustomerId(Long customerId) {
    return petRepository.findPetByCustomerId(customerId);
  }
}
