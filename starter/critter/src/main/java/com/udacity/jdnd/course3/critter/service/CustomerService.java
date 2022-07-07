package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.entities.Customer;
import com.udacity.jdnd.course3.critter.entities.Pet;
import com.udacity.jdnd.course3.critter.exception.UserNotFoundException;
import com.udacity.jdnd.course3.critter.repository.CustomerRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  @Autowired private CustomerRepository customerRepository;

  @Autowired private PetRepository petRepository;

  public Customer save(Customer customer) {
    return customerRepository.save(customer);
  }

  public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
  }

  public Customer getById(Long id) {
    Optional<Customer> customer = customerRepository.findById(id);
    return customer.orElseThrow(UserNotFoundException::new);
  }

  public Customer getOwnerByPet(Long petId) {
    Optional<Pet> pet = petRepository.findById(petId);
    if (!pet.isPresent()) {
      throw new UserNotFoundException("no such pet exists!");
    }

    Customer customer = customerRepository.findByPetsContaining(pet.get());
    if (customer == null) {
      throw new UserNotFoundException("User not found");
    } else {
      return customer;
    }
  }


}
