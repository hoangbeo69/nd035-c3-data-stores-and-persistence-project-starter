package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.entities.Customer;
import com.udacity.jdnd.course3.critter.entities.Employee;
import com.udacity.jdnd.course3.critter.entities.Pet;
import com.udacity.jdnd.course3.critter.entities.Schedule;
import com.udacity.jdnd.course3.critter.exception.UserNotFoundException;
import com.udacity.jdnd.course3.critter.repository.ScheduleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

  @Autowired private ScheduleRepository scheduleRepository;

  public ScheduleService(ScheduleRepository scheduleRepository) {
    this.scheduleRepository = scheduleRepository;
  }

  public Schedule save(Schedule schedule) {
    Schedule scheduleSaved = scheduleRepository.save(schedule);
    return scheduleRepository.getById(scheduleSaved.getId()).orElseThrow(() -> new UserNotFoundException());
  }

  public List<Schedule> getAllSchedules() {
    return scheduleRepository.findAll();
  }

  public List<Schedule> getSchedulesByPet(Pet pet) {
    return scheduleRepository.findByPetListContaining(pet);
  }

  public List<Schedule> getSchedulesByEmployee(Employee employee) {
    return scheduleRepository.findByEmployeeListContaining(employee);
  }

  public List<Schedule> getSchedulesByCustomer(Customer customer) {
    List<Schedule> schedules = scheduleRepository.findByPetListIn(customer.getPets());
    return schedules;
  }

  public List<Schedule> getSchedulesByPetList(List<Pet> pets) {
    return scheduleRepository.findByPetListIn(pets);
  }
}
