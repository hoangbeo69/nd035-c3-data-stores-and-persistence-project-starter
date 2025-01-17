package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.entities.Employee;
import com.udacity.jdnd.course3.critter.user.EmployeeSkill;
import java.time.DayOfWeek;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

  List<Employee> findByDaysAvailableContaining(DayOfWeek dayOfWeek);

  List<Employee> findBySkillsContaining(EmployeeSkill skill);

  List<Employee> findAllByIdIsIn(List<Long> ids);
}
