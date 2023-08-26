package com.booking.jpahotelbooking.repository;

import com.booking.jpahotelbooking.entity.Employee;
import com.booking.jpahotelbooking.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    @Query("SELECT e FROM Employee e JOIN e.hotel h WHERE h.hotelName = :hotelName")
    Set<Employee> findAllEmployeesByHotelName(@Param("hotelName") String hotelName);
}