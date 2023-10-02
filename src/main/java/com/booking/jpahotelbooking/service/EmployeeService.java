package com.booking.jpahotelbooking.service;

import com.booking.jpahotelbooking.exception.EmployeeNotModifiedException;
import com.booking.jpahotelbooking.entity.dto.employee.EmployeeRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.booking.jpahotelbooking.repository.EmployeeRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import com.booking.jpahotelbooking.entity.Employee;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;

import java.util.NoSuchElementException;
import java.util.List;

@RequiredArgsConstructor

@Service
public class EmployeeService implements UserDetailsService {

    private final EmployeeRepository employeeRepository;

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

    public Employee createEmployee(EmployeeRequestDTO employeeReqDTO) {

        try {

            Employee employee = new Employee();

            employee.setFirstName(employeeReqDTO.getFirstName());
            employee.setLastName(employeeReqDTO.getLastName());
            employee.setHotel(employeeReqDTO.getHotel());
            employee.setRole(List.of(employeeReqDTO.getRole()));
            employee.setEmail(employeeReqDTO.getEmail());
            employee.setPassword(employeeReqDTO.getPassword());
            employee.setPassportInfo(employeeReqDTO.getPassportInfo());

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
            changedEmployee.setRole(List.of(employee.getRole()));
            changedEmployee.setHotel(employee.getHotel());
            changedEmployee.setPhone(employee.getPhone());
            changedEmployee.setEmail(employee.getEmail());
            changedEmployee.setPassword(employee.getPassword());
            changedEmployee.setPassportInfo(employee.getPassportInfo());

            employeeRepository.save(changedEmployee);

            return id;
        }
        catch (Exception e) {

            throw new EmployeeNotModifiedException(
                    "Employee hasn't modified"
            );
        }
    }

    public String deleteEmployeeById(Long id) {

        try {

            employeeRepository.deleteById(id);

            return "Employee has deleted successfully";
        }
        catch (ResponseStatusException e) {

            return "Status: " + HttpStatus.NO_CONTENT + " message: " + e.getMessage();
        }
        catch (EmptyResultDataAccessException e) {

            return "Employee with ID " + id + " not found";
        }
        catch (Exception e) {

            return "An error occurred while deleting employee: " + e.getMessage();
        }
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Employee employee = employeeRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("Employee with [%s] not found", username)
                ));

        return new User(
                employee.getEmail(),
                employee.getPassword(),
                employee.getRole().stream().map(role -> new SimpleGrantedAuthority(role.getRoleType())).toList()
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