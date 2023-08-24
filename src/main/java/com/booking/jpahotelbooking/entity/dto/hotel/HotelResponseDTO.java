package com.booking.jpahotelbooking.entity.dto.hotel;

import com.booking.jpahotelbooking.entity.Employee;
import com.booking.jpahotelbooking.entity.HotelLocation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

@Data
public class HotelResponseDTO {

    @NotEmpty
    private String hotelName;
    @NotNull
    private HotelLocation hotelLocation;
    @JsonIgnore
    private Set<Employee> employees;
}