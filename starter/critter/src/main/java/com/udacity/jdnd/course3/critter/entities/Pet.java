package com.udacity.jdnd.course3.critter.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

/**
 * @author smurF3r Created on 7/3/2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Pet {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

  @Column(name = "pet_type", length = 50) private String type;

  @Nationalized @Column(length = 50) private String name;

  @ManyToOne @JoinColumn(name = "customer_id") private Customer customer;

  private LocalDate birthDate;
  private String notes;

  public Pet(String type, String name, Customer customer, LocalDate birthDate, String notes) {
    this.type = type;
    this.name = name;
    this.customer = customer;
    this.birthDate = birthDate;
    this.notes = notes;
  }
}
