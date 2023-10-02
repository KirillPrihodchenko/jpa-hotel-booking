package com.booking.jpahotelbooking.repository;

import com.booking.jpahotelbooking.entity.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {

    Optional<Guest> findByLastName(String lastName);

    Optional<Guest> findByEmail(String email);
}