package com.udacity.jdnd.course3.critter.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

/**
 * @author smurF3r Created on 7/6/2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 50)
  @Nationalized
  private String name;

  @Column(length = 500)
  private String notes;

  @Column(name = "phone_number", length = 20)
  private String phoneNumber;
}
