package com.booking.jpahotelbooking.service;

import com.booking.jpahotelbooking.entity.Employee;
import com.booking.jpahotelbooking.entity.dto.employee.EmployeeRequestDTO;
import com.booking.jpahotelbooking.entity.dto.role.RoleDTO;
import com.booking.jpahotelbooking.repository.EmployeeRepository;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@AllArgsConstructor

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final RoleService roleService;

    public Iterable<Employee> getAll() {

        try {

            return employeeRepository.findAll();
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

    public Employee updateEmployee(Long id, EmployeeRequestDTO employee, RoleDTO roles) {

        try {

            Employee changedEmployee = existEmployee(id);

            changedEmployee.setFirstName(employee.getFirstName());
            changedEmployee.setLastName(employee.getLastName());
            changedEmployee.setRoles(roleService.createRole(roles));
            changedEmployee.setHotel(employee.getHotel());
            changedEmployee.setPhone(employee.getPhone());
            changedEmployee.setSalary(employee.getSalary());

            return employeeRepository.save(changedEmployee);
        }
        catch (Exception e) {

            throw new ResponseStatusException (
                    HttpStatus.BAD_REQUEST,
                    "Employer not updated", e
            );
        }
    }

    public void deleteEmployeeById(Long id) {

        try {

            employeeRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {

            System.out.println("Employee with ID " + id + " not found");
        }
        catch (Exception e) {

            System.out.println("An error occurred while deleting employee: " + e.getMessage());
        }
    }

    public Employee getByLastNameAndPassportInfo(String lastName, String passportInfo) {

        return employeeRepository
                .findByLastNameAndPassportInfo(lastName, passportInfo)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("Employee with this %s and %s not found", lastName, passportInfo)
                )
        );
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