package com.udacity.jdnd.course3.critter.controller;

import com.udacity.jdnd.course3.critter.entities.Customer;
import com.udacity.jdnd.course3.critter.entities.Employee;
import com.udacity.jdnd.course3.critter.mapper.UserMapper;
import com.udacity.jdnd.course3.critter.service.CustomerService;
import com.udacity.jdnd.course3.critter.service.EmployeeService;
import com.udacity.jdnd.course3.critter.user.CustomerDTO;
import com.udacity.jdnd.course3.critter.user.EmployeeDTO;
import com.udacity.jdnd.course3.critter.user.EmployeeRequestDTO;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handles web requests related to Users.
 * <p>
 * Includes requests for both customers and employees. Splitting this into separate user and
 * customer controllers would be fine too, though that is not part of the required scope for this
 * class.
 */
@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired private CustomerService customerService;

  @Autowired private EmployeeService employeeService;

  @Autowired private UserMapper userMapper;

  @PostMapping("/customer")
  public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO) {
    Customer customer = userMapper.map(customerDTO);
    Customer JPACustomer = customerService.save(customer);
    return userMapper.map(JPACustomer);
  }

  @GetMapping("/customer")
  public List<CustomerDTO> getAllCustomers() {
    List<Customer> customerList = customerService.getAllCustomers();
    return userMapper.map(customerList);
  }

  @GetMapping("/customer/pet/{petId}")
  public CustomerDTO getOwnerByPet(@PathVariable long petId) {
    Customer customer = customerService.getOwnerByPet(petId);
    return userMapper.map(customer);
  }

  @PostMapping("/employee")
  public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
    Employee employee = userMapper.map(employeeDTO);
    Employee JPAEmployee = employeeService.save(employee);

    return userMapper.map(JPAEmployee);
  }

  @PostMapping("/employee/{employeeId}")
  public EmployeeDTO getEmployee(@PathVariable long employeeId) {
    Employee employee = employeeService.getById(employeeId);
    return userMapper.map(employee);
  }

  @PutMapping("/employee/{employeeId}")
  public void setAvailability(@RequestBody Set<DayOfWeek> daysAvailable,
      @PathVariable long employeeId) {
    employeeService.setAvailability(daysAvailable, employeeId);
  }

  @GetMapping("/employee/availability")
  public List<EmployeeDTO> findEmployeesForService(@RequestBody EmployeeRequestDTO employeeDTO) {
    List<Employee> employeeList = employeeService.getByAvailableForService(employeeDTO);
    return userMapper.mapEmployees(employeeList);
  }

}
