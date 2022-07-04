package com.udacity.jdnd.course3.critter.entities;

import com.udacity.jdnd.course3.critter.pet.PetType;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author smurF3r Created on 7/3/2022
 */
@Data
@Entity
@Table
public class Pet {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private PetType type;
  private LocalDate birthDate;
  private String notes;
  @ManyToOne
  @JoinColumn(name = "owner_id")
  private Customer owner;
}
