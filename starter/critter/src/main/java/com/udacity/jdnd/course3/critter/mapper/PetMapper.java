package com.udacity.jdnd.course3.critter.mapper;

import com.udacity.jdnd.course3.critter.entities.Pet;
import com.udacity.jdnd.course3.critter.pet.PetDTO;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

/**
 * @author smurF3r Created on 7/7/2022
 */
@Mapper(componentModel = "spring")
public interface PetMapper {

  Pet map(PetDTO petDTO);

  @Mapping(source = "pet.customer.id",target = "ownerId")
  PetDTO map(Pet pet);

  List<PetDTO> map(List<Pet> pets);

  @Named("mapListPetToListId")
  default List<Long> mapToListId(List<Pet> pets) {
    return pets != null ?
     pets.stream()
        .map(Pet::getId)
        .collect(Collectors.toList())
        : null;
  }
}
