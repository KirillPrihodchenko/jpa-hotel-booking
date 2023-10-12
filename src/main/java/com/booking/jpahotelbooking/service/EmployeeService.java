package com.booking.jpahotelbooking.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.booking.jpahotelbooking.exception.EmployeeNotModifiedException;
import com.booking.jpahotelbooking.entity.dto.employee.EmployeeRequestDTO;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.booking.jpahotelbooking.exception.EmployeeCreationException;
import com.booking.jpahotelbooking.auth.dto.RegistrationEmployeeDTO;
import org.springframework.security.core.userdetails.UserDetails;
import com.booking.jpahotelbooking.repository.EmployeeRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.server.ResponseStatusException;
import com.booking.jpahotelbooking.repository.RoleRepository;
import org.springframework.security.core.userdetails.User;
import com.booking.jpahotelbooking.entity.Employee;
import com.booking.jpahotelbooking.entity.eRole;
import com.booking.jpahotelbooking.entity.Role;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;

import java.util.NoSuchElementException;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor

@Service
public class EmployeeService implements UserDetailsService {

    private final EmployeeRepository employeeRepository;
    private final RoleRepository roleRepository;
    private final EmailService emailService;

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

    public Long updateEmployee(Long id, EmployeeRequestDTO employee) {

        try {

            Employee changedEmployee = existEmployee(id);

            changedEmployee.setFirstName(employee.getFirstName());
            changedEmployee.setLastName(employee.getLastName());
            changedEmployee.setRole(Set.of(employee.getRole()));
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

    public void createEmployee(RegistrationEmployeeDTO registrationEmployeeDTO) {

        if (!employeeRepository.existsByEmail(registrationEmployeeDTO.getEmail())) {

            Employee createdEmployee = new Employee();

            createdEmployee.setFirstName(registrationEmployeeDTO.getFirstName());
            createdEmployee.setLastName(registrationEmployeeDTO.getLastName());
            createdEmployee.setEmail(registrationEmployeeDTO.getEmail());
            createdEmployee.setPassword(registrationEmployeeDTO.getPassword());

            Role defaultRole = roleRepository.findByRoleType(eRole.ROLE_MODERATOR);

            createdEmployee.setRole(Set.of(defaultRole));
            createdEmployee.setPhone(registrationEmployeeDTO.getPhone());

            String fullName = registrationEmployeeDTO.getFirstName()
                    .concat(" ")
                    .concat(registrationEmployeeDTO.getLastName());
            emailService.sendSimpleMessage(registrationEmployeeDTO.getEmail(), fullName);

            employeeRepository.save(createdEmployee);
        }
        else {
            throw new EmployeeCreationException("Employee hasn't created");
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
                employee.getRole()
                        .stream()
                        .map(role -> new SimpleGrantedAuthority(role.getRoleType().extractRoleProperty()))
                        .toList()
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