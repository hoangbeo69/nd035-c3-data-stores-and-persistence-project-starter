package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.entities.Employee;
import com.udacity.jdnd.course3.critter.entities.Pet;
import com.udacity.jdnd.course3.critter.entities.Schedule;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

  List<Schedule> findByPetListContaining(Pet pet);

  List<Schedule> findByEmployeeListContaining(Employee employee);

  List<Schedule> findByPetListIn(List<Pet> pets);
}
