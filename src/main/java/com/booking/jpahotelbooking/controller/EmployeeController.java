package com.booking.jpahotelbooking.controller;

import com.booking.jpahotelbooking.entity.dto.employee.EmployeeRequestDTO;
import com.booking.jpahotelbooking.service.EmployeeService;
import com.booking.jpahotelbooking.entity.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@AllArgsConstructor

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {

        return new ResponseEntity<>(
                employeeService.getAll(),
                HttpStatus.OK);
    }

    @GetMapping("/byFullName")
    public ResponseEntity<Employee> getEmployeeByFullName(
            @RequestParam @Validated String firstName, @RequestParam @Validated String lastName) {

        return new ResponseEntity<>(
                employeeService.getEmployeeByFirstNameAndLastName(firstName, lastName),
                HttpStatus.OK
        );
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(
            @RequestBody @Validated EmployeeRequestDTO employeeRequestDTO) {

        return new ResponseEntity<>(
                employeeService.createEmployee(employeeRequestDTO),
                HttpStatus.CREATED
        );
    }

    @PatchMapping("/{id}/update")
    public ResponseEntity<Long> partialUpdateEmployee(
            @PathVariable Long id,
            @RequestBody @Validated EmployeeRequestDTO employeeRequestDTO) {

        return new ResponseEntity<>(
                employeeService.updateEmployee(id, employeeRequestDTO),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Long> deleteEmployee(@PathVariable Long id) {

        return new ResponseEntity<>(
                employeeService.deleteEmployeeById(id),
                HttpStatus.OK
        );
    }
}