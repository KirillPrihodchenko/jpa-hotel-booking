package com.booking.jpahotelbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.booking.jpahotelbooking.entity.Registration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    @Query("SELECT r FROM Registration r WHERE r.tsCheckIn = :timeIn")
    Optional<List<Registration>> findRegistrationByTsCheckIn(LocalDateTime timeIn);
}