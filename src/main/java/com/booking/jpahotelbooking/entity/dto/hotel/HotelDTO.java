package com.booking.jpahotelbooking.entity.dto.hotel;

import com.booking.jpahotelbooking.entity.Employees;
import com.booking.jpahotelbooking.entity.HotelLocation;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

@Data
public class HotelDTO {

    @NotEmpty
    private String hotelName;
    @NotNull
    private HotelLocation hotelLocation;
    private Set<Employees> employees;
}