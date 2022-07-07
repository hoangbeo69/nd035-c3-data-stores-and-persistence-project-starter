package com.udacity.jdnd.course3.critter.mapper;

import com.udacity.jdnd.course3.critter.entities.Pet;
import com.udacity.jdnd.course3.critter.pet.PetDTO;
import java.util.List;
import org.mapstruct.Mapper;

/**
 * @author smurF3r Created on 7/7/2022
 */
@Mapper(componentModel = "spring")
public interface PetMapper {

  Pet map(PetDTO petDTO);

  PetDTO map(Pet pet);

  List<PetDTO> map(List<Pet> pets);
}
