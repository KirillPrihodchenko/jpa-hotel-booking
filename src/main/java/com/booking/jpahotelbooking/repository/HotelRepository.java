package com.booking.jpahotelbooking.repository;

import com.booking.jpahotelbooking.entity.Employees;
import com.booking.jpahotelbooking.entity.Hotel;
import com.booking.jpahotelbooking.entity.dto.hotel.HotelResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    Optional<HotelResponseDTO> findHotelByHotelName(String hotelName);
    List<Employees> findAllEmployeesByHotelName(String hotelName);
}