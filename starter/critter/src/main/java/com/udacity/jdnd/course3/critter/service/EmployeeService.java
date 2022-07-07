package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.entities.Employee;
import com.udacity.jdnd.course3.critter.exception.UserNotFoundException;
import com.udacity.jdnd.course3.critter.repository.EmployeeRepository;
import com.udacity.jdnd.course3.critter.user.EmployeeRequestDTO;
import com.udacity.jdnd.course3.critter.user.EmployeeSkill;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

  @Autowired private EmployeeRepository employeeRepository;


  public Employee save(Employee employee) {
    return employeeRepository.save(employee);
  }

  public Employee getById(Long id) {
    Optional<Employee> employee = employeeRepository.findById(id);
    return employee.orElseThrow(UserNotFoundException::new);
  }

  public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
  }

  public void setAvailability(Set<DayOfWeek> daysAvailable, Long employeeId) {
    Employee employee = getById(employeeId);
    employee.setDaysAvailable(daysAvailable);
    save(employee);
  }

  public List<Employee> getByAvailableForService(EmployeeRequestDTO employeeRequestDTO) {
    DayOfWeek requestDay = employeeRequestDTO.getDate().getDayOfWeek();
    Set<EmployeeSkill> requestSkills = employeeRequestDTO.getSkills();
    List<Employee> employees = employeeRepository.findByDaysAvailableContaining(requestDay).stream()
        .filter(employee -> employee.getSkills().containsAll(requestSkills))
        .collect(Collectors.toList());

    return employees;
  }
}
