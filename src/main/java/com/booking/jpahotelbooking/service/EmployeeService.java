package com.booking.jpahotelbooking.service;

import com.booking.jpahotelbooking.entity.Employee;
import com.booking.jpahotelbooking.entity.dto.employee.EmployeeMapper;
import com.booking.jpahotelbooking.entity.dto.employee.EmployeeRequestDTO;
import com.booking.jpahotelbooking.repository.EmployeeRepository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public List<Employee> getAll() {

        try {

            return (List<Employee>) employeeRepository.findAll();
        }
        catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Employees not found", e);
        }
    }

    public Employee getEmployeeByFirstNameAndLastName(
            @NotBlank(message = "Employee first name must not be blank") String firstName,
            @NotBlank(message = "Employee last name must not be blank") String lastName) {

        return employeeRepository
                .findEmployeeByFirstNameAndLastName(firstName, lastName)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("Employee %s %s not found", firstName, lastName)
        ));
    }

    public Employee createEmployee(@NotNull EmployeeRequestDTO employeeReqDTO) {

        try {

            Employee employee = employeeMapper.convertToEntity(employeeReqDTO);

            return employeeRepository.save(employee);
        }
        catch (Exception e) {

            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    e.getMessage());
        }
    }

    public Long updateEmployee(Long id, EmployeeRequestDTO employee) {

        try {

            Employee changedEmployee = existEmployee(id);

            changedEmployee.setFirstName(employee.getFirstName());
            changedEmployee.setLastName(employee.getLastName());
            changedEmployee.setRoles(employee.getRoles());
            changedEmployee.setHotel(employee.getHotel());
            changedEmployee.setPhone(employee.getPhone());
            changedEmployee.setSalary(employee.getSalary());

            employeeRepository.save(changedEmployee);

            return id;
        }
        catch (Exception e) {
            throw new ResponseStatusException (
                    HttpStatus.NOT_MODIFIED,
                    "Employee hasn't modified", e
            );
        }
    }

    public Long deleteEmployeeById(Long id) {

        try {

            employeeRepository.deleteById(id);
            return id;
        }
        catch (ResponseStatusException e) {

            System.out.println("Status: " + HttpStatus.NO_CONTENT + " message: " + e.getMessage());
            return -1L;
        }
        catch (EmptyResultDataAccessException e) {

            System.out.println("Employee with ID " + id + " not found");
            return -2L;
        }
        catch (Exception e) {

            System.out.println("An error occurred while deleting employee: " + e.getMessage());
            return -3L;
        }
    }

    private Employee existEmployee(Long id) {

        return employeeRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("Employee with id [%d] not found", id)
                )
        );
    }
}