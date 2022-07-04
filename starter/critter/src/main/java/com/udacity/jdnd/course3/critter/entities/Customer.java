package com.udacity.jdnd.course3.critter.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;


/**
 * @author smurF3r Created on 7/3/2022
 */
@Data
@Entity
@Table
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String phoneNumber;
  private String notes;
  @OneToMany(mappedBy = "owner")
  private List<Pet> pets;

}
