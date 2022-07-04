package com.udacity.jdnd.course3.critter.entities;

import com.udacity.jdnd.course3.critter.user.EmployeeSkill;
import java.time.DayOfWeek;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author smurF3r Created on 7/3/2022
 */
@Data
@Entity
@Table
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  @ElementCollection
  private List<EmployeeSkill> skills;
  @ElementCollection
  private List<DayOfWeek> daysAvailable;
}
