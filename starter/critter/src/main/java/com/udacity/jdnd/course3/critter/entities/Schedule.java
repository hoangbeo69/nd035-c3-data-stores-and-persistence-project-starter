package com.udacity.jdnd.course3.critter.entities;

import java.time.LocalDate;
import java.util.List;

/**
 * @author smurF3r Created on 7/3/2022
 */
public class Schedule {
  private Long id;
  private List<Employee> employees;
  private List<Pet> pets;
  private LocalDate date;
}
