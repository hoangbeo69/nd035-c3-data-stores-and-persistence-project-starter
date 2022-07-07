package com.udacity.jdnd.course3.critter.controller;

import com.udacity.jdnd.course3.critter.entities.Customer;
import com.udacity.jdnd.course3.critter.entities.Pet;
import com.udacity.jdnd.course3.critter.mapper.PetMapper;
import com.udacity.jdnd.course3.critter.pet.PetDTO;
import com.udacity.jdnd.course3.critter.service.CustomerService;
import com.udacity.jdnd.course3.critter.service.PetService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handles web requests related to Pets.
 */
@RestController
@RequestMapping("/pet")
public class PetController {

  @Autowired private PetService petService;
  @Autowired private CustomerService customerService;

  @Autowired private PetMapper petMapper;

  @PostMapping
  public PetDTO savePet(@RequestBody PetDTO petDTO) {
    if (petDTO == null) {
      return null;
    }
    Pet pet = petMapper.map(petDTO);
    Pet JPAPet = petService.save(pet);
    Customer customer = customerService.getById(petDTO.getOwnerId());
    customer.addPet(JPAPet);
    customerService.save(customer);
    return petMapper.map(JPAPet);
  }

  @GetMapping("/{petId}")
  public PetDTO getPet(@PathVariable long petId) {
    Pet pet = petService.getPetById(petId);
    return petMapper.map(pet);
  }

  @GetMapping
  public List<PetDTO> getPets() {
    List<Pet> pets = petService.getAllPets();
    return petMapper.map(pets);
  }

  @GetMapping("/owner/{ownerId}")
  public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
    List<Pet> pets = petService.getPetsByCustomerId(ownerId);
    return petMapper.map(pets);
  }
}
