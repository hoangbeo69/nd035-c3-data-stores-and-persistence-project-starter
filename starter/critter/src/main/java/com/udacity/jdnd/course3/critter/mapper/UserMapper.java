package com.udacity.jdnd.course3.critter.mapper;

import com.udacity.jdnd.course3.critter.entities.Customer;
import com.udacity.jdnd.course3.critter.entities.Employee;
import com.udacity.jdnd.course3.critter.user.CustomerDTO;
import com.udacity.jdnd.course3.critter.user.EmployeeDTO;
import java.util.List;
import org.mapstruct.Mapper;

/**
 * @author smurF3r Created on 7/7/2022
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

  Customer map(CustomerDTO customer);

  CustomerDTO map(Customer customer);

  List<CustomerDTO> map(List<Customer> customers);

  Employee map(EmployeeDTO employeeDTO);

  EmployeeDTO map(Employee employee);

  List<EmployeeDTO> mapEmployees(List<Employee> employees);
}
