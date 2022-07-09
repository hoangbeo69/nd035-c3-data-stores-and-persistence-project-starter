package com.udacity.jdnd.course3.critter.mapper;

import com.udacity.jdnd.course3.critter.entities.Customer;
import com.udacity.jdnd.course3.critter.entities.Employee;
import com.udacity.jdnd.course3.critter.user.CustomerDTO;
import com.udacity.jdnd.course3.critter.user.EmployeeDTO;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

/**
 * @author smurF3r Created on 7/7/2022
 */
@Mapper(componentModel = "spring",uses = {PetMapper.class})
public interface UserMapper {

  Customer map(CustomerDTO customer);

  @Mapping(source = "customer.pets",target = "petIds",qualifiedByName = {"mapListPetToListId"})
  CustomerDTO map(Customer customer);

  List<CustomerDTO> map(List<Customer> customers);

  Employee map(EmployeeDTO employeeDTO);

  EmployeeDTO map(Employee employee);

  List<EmployeeDTO> mapEmployees(List<Employee> employees);

  @Named("mapEmployeeToListId")
  default List<Long> mapToListId(List<Employee> employees){
    return null != employees ?
        employees.stream().map(Employee::getId)
            .collect(Collectors.toList())
        : null;
  }
}
