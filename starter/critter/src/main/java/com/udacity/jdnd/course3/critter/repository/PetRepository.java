package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.entities.Pet;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface PetRepository extends JpaRepository<Pet, Long> {

  List<Pet> findPetByCustomerId(Long customerId);

  List<Pet> findAllByIdIsIn(List<Long> ids);
}
