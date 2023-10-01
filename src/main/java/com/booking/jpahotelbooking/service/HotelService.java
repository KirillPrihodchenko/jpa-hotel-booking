package com.booking.jpahotelbooking.service;

import com.booking.jpahotelbooking.entity.dto.employee.EmployeeResponseDTO;
import com.booking.jpahotelbooking.entity.dto.employee.EmployeeMapper;
import com.booking.jpahotelbooking.entity.dto.hotel.HotelResponseDTO;
import com.booking.jpahotelbooking.entity.dto.hotel.HotelMapper;
import com.booking.jpahotelbooking.repository.HotelRepository;
import org.springframework.web.server.ResponseStatusException;
import com.booking.jpahotelbooking.entity.Employee;
import com.booking.jpahotelbooking.entity.Hotel;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Set;

@AllArgsConstructor

@Service
public class HotelService {

    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;
    private final EmployeeMapper employeesMapper;

    public List<HotelResponseDTO> getAll() {

        try {

            List<Hotel> hotelList = hotelRepository.findAll();
            return hotelList
                    .stream()
                    .map(hotelMapper::convertToDto)
                    .toList();
        }
        catch (NoSuchElementException e) {

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Hotels not found", e);
        }
    }

    public Set<EmployeeResponseDTO> getAllEmployeesByHotelName(
            @NotBlank(message = "Hotel name must not be blank") String hotelName) {

        Set<Employee> employeesSet = hotelRepository.findAllEmployeesByHotelName(hotelName);

        if (employeesSet.isEmpty()) {

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    String.format("Employees in hotel [%s] not found", hotelName));
        }
        return employeesSet
                .stream()
                .map(employeesMapper::convertToDto)
                .collect(Collectors.toSet());
    }
}