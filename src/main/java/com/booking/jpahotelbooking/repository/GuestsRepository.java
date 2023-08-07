package com.booking.jpahotelbooking.repository;

import com.booking.jpahotelbooking.entity.Guests;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuestsRepository extends CrudRepository<Guests, Long> {

    Optional<Guests> findByLastNameAndPhone(String lastName, String phone);
}
