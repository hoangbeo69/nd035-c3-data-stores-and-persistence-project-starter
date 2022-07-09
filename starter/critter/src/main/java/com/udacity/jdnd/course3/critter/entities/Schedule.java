package com.udacity.jdnd.course3.critter.entities;

import com.udacity.jdnd.course3.critter.user.EmployeeSkill;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author smurF3r Created on 7/3/2022
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Schedule {

  @Id @GeneratedValue(strategy = GenerationType.AUTO) private Long id;

  @ManyToMany List<Employee> employeeList;

  @ManyToMany List<Pet> petList;

  private LocalDate date;

  @Column(name = "activities")
  @ElementCollection(fetch = FetchType.EAGER, targetClass = EmployeeSkill.class)
  @CollectionTable(name = "schedule_activity", joinColumns = @JoinColumn(name = "activity_id"))
  private Set<EmployeeSkill> skills;
}
