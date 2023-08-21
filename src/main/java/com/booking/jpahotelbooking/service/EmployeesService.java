package com.booking.jpahotelbooking.service;

import com.booking.jpahotelbooking.entity.Employees;
import com.booking.jpahotelbooking.entity.dto.employee.EmployeeRequestDTO;
import com.booking.jpahotelbooking.entity.dto.role.RoleDTO;
import com.booking.jpahotelbooking.repository.EmployeesRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EmployeesService {

    private final EmployeesRepository employeesRepository;
    private final RoleService roleService;

    public EmployeesService(EmployeesRepository employeesRepository, RoleService roleService) {
        this.employeesRepository = employeesRepository;
        this.roleService = roleService;
    }

    public Iterable<Employees> getAll() {
        return employeesRepository.findAll();
    }

    public Employees getEmployeeByName(Long id) {
        return employeesRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Employee with id %d not found", id)
        ));
    }

    public Employees updateEmployee(Long id, EmployeeRequestDTO employees, RoleDTO roles) {

        Employees existingEmployee = getExistingEmployee(id);

        existingEmployee.setFirstName(employees.getFirstName());
        existingEmployee.setLastName(employees.getLastName());
        existingEmployee.setRoles(roleService.createRole(roles));
        existingEmployee.setPhone(employees.getPhone());
        existingEmployee.setSalary(employees.getSalary());

        return existingEmployee;
    }

    public void deleteEmployeeById(Long id) {
        employeesRepository.deleteById(id);
    }

    public Employees getByLastNameAndPassportInfo(String lastName, String passportInfo) {
        return employeesRepository
                .findByLastNameAndPassportInfo(lastName, passportInfo)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Employee with this %s and %s not found", lastName, passportInfo)
        ));
    }

    private Employees getExistingEmployee(Long id) {
        return employeesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Employee with id %d not found", id)
                ));
    }
}