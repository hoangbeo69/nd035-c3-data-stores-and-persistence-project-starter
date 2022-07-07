package com.udacity.jdnd.course3.critter.controller;

import com.udacity.jdnd.course3.critter.entities.Schedule;
import com.udacity.jdnd.course3.critter.mapper.ScheduleMapper;
import com.udacity.jdnd.course3.critter.schedule.ScheduleDTO;
import com.udacity.jdnd.course3.critter.service.CustomerService;
import com.udacity.jdnd.course3.critter.service.EmployeeService;
import com.udacity.jdnd.course3.critter.service.PetService;
import com.udacity.jdnd.course3.critter.service.ScheduleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handles web requests related to Schedules.
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

  @Autowired private ScheduleService scheduleService;

  @Autowired private EmployeeService employeeService;

  @Autowired private PetService petService;

  @Autowired private ScheduleMapper scheduleMapper;

  @Autowired private CustomerService customerService;

  @PostMapping
  public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
    Schedule schedule = scheduleMapper.map(scheduleDTO);
    Schedule JPASchedule = scheduleService.save(schedule);
    return scheduleMapper.map(JPASchedule);
  }

  @GetMapping
  public List<ScheduleDTO> getAllSchedules() {
    List<Schedule> schedules = scheduleService.getAllSchedules();
    return scheduleMapper.map(schedules);
  }

  @GetMapping("/pet/{petId}")
  public List<ScheduleDTO> getScheduleForPet(@PathVariable long petId) {
    List<Schedule> schedules = scheduleService.getSchedulesByPet(petService.getPetById(petId));
    return scheduleMapper.map(schedules);
  }

  @GetMapping("/employee/{employeeId}")
  public List<ScheduleDTO> getScheduleForEmployee(@PathVariable long employeeId) {
    List<Schedule> schedules = scheduleService.getSchedulesByEmployee(
        employeeService.getById(employeeId));
    return scheduleMapper.map(schedules);
  }

  @GetMapping("/customer/{customerId}")
  public List<ScheduleDTO> getScheduleForCustomer(@PathVariable long customerId) {
    List<Schedule> schedules = scheduleService.getSchedulesByCustomer(
        customerService.getById(customerId));
    List<ScheduleDTO> scheduleDTOS = scheduleMapper.map(schedules);
    return scheduleDTOS;
  }
}
