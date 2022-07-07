package com.udacity.jdnd.course3.critter.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author smurF3r Created on 7/3/2022
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "customer")
@AttributeOverrides({
    @AttributeOverride(name="id",
        column = @Column(name="customer_id")),
    @AttributeOverride(name="name",
        column = @Column(name="customer_name"))
})
public class Customer extends User {

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
  private List<Pet> pets;
  public Customer(List<Pet> pets) {
    this.pets = pets;
  }
  public void addPet(Pet pet) {
    if (pets == null) {
      pets = new ArrayList<>();
    }

    this.pets.add(pet);
  }
}
