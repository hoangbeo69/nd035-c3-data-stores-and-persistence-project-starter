package com.udacity.jdnd.course3.critter.entities;

import com.udacity.jdnd.course3.critter.user.EmployeeSkill;
import java.time.DayOfWeek;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
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
@Table(name = "employee")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "employee_id")),
    @AttributeOverride(name = "name", column = @Column(name = "employee_name"))})
public class Employee extends User{

  @ElementCollection(fetch = FetchType.EAGER, targetClass = EmployeeSkill.class) @CollectionTable(name = "employee_skill", joinColumns = @JoinColumn(name = "employee_id")) private Set<EmployeeSkill> skills;

  @Column(name = "available_day") @ElementCollection(fetch = FetchType.EAGER, targetClass = DayOfWeek.class) @CollectionTable(name = "employee_availableDay", joinColumns = @JoinColumn(name = "employee_id")) private Set<DayOfWeek> daysAvailable;


  public Employee(Set<EmployeeSkill> skills, Set<DayOfWeek> daysAvailable) {
    this.skills = skills;
    this.daysAvailable = daysAvailable;
  }

  public Employee(Long id, String name, String notes, String phoneNumber, Set<EmployeeSkill> skills,
      Set<DayOfWeek> daysAvailable) {
    super(id, name, notes, phoneNumber);
    this.skills = skills;
    this.daysAvailable = daysAvailable;
  }
}
