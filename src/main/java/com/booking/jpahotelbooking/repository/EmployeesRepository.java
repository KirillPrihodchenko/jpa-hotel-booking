package com.booking.jpahotelbooking.repository;

import com.booking.jpahotelbooking.entity.Employees;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeesRepository extends CrudRepository<Employees, Long> {

    Optional<Employees> findByLastNameAndPassportInfo(String lastName, String passportInfo);
}