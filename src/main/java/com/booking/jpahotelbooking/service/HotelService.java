package com.booking.jpahotelbooking.service;

import com.booking.jpahotelbooking.entity.Employees;
import com.booking.jpahotelbooking.entity.Hotel;
import com.booking.jpahotelbooking.entity.dto.hotel.HotelResponseDTO;
import com.booking.jpahotelbooking.exception.HotelException;
import com.booking.jpahotelbooking.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public HotelResponseDTO getHotelByName(String name) throws HotelException {
        return hotelRepository
                .findHotelByHotelName(name)
                .orElseThrow(() -> new HotelException(
                        String.format("Hotel with name %s not found", name)
                ));
    }

    // check in the postman for changes to the list from the dto in the controller
    public Iterable<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    public Set<Employees> getAllEmployeesByHotelName(String hotelName) throws HotelException {
        HotelResponseDTO hotel = getHotelByName(hotelName);
        return hotel.getEmployees();
    }
}