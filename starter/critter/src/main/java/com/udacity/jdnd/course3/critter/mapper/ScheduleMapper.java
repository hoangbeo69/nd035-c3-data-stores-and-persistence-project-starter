package com.udacity.jdnd.course3.critter.mapper;

import com.udacity.jdnd.course3.critter.entities.Schedule;
import com.udacity.jdnd.course3.critter.schedule.ScheduleDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author smurF3r Created on 7/7/2022
 */
@Mapper(componentModel = "spring",uses = {UserMapper.class,PetMapper.class})
public interface ScheduleMapper {

  @Mapping(source ="activities",target = "skills")
  Schedule map(ScheduleDTO scheduleDTO);

  @Mapping(source = "skills",target="activities")
  @Mapping(source = "employeeList",target = "employeeIds",qualifiedByName = {"mapEmployeeToListId"})
  @Mapping(source = "petList", target = "petIds",qualifiedByName = {"mapListPetToListId"})
  ScheduleDTO map(Schedule schedule);

  List<ScheduleDTO> map(List<Schedule> schedules);
}
