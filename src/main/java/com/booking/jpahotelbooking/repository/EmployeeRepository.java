package com.booking.jpahotelbooking.repository;

import com.booking.jpahotelbooking.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Optional<Employee> findEmployeeByFirstNameAndLastName(String firstName, String lastName);

    Optional<Employee> findByLastNameAndPassportInfo(String lastName, String passportInfo);
}