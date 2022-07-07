package com.udacity.jdnd.course3.critter.mapper;

import com.udacity.jdnd.course3.critter.entities.Schedule;
import com.udacity.jdnd.course3.critter.schedule.ScheduleDTO;
import java.util.List;
import org.mapstruct.Mapper;

/**
 * @author smurF3r Created on 7/7/2022
 */
@Mapper(componentModel = "spring")
public interface ScheduleMapper {

  Schedule map(ScheduleDTO scheduleDTO);

  ScheduleDTO map(Schedule schedule);

  List<ScheduleDTO> map(List<Schedule> schedules);
}
