package com.booking.jpahotelbooking.controller;

import com.booking.jpahotelbooking.service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.AllArgsConstructor;

@AllArgsConstructor

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final HotelService hotelService;

    @GetMapping
    public ResponseEntity<?> getAllHotels() {

        return new ResponseEntity<>(
                hotelService.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/employees")
    public ResponseEntity<?> getAllEmployeesByHotelName(
                            @RequestParam @Validated String hotelName) {

        return new ResponseEntity<>(
                hotelService.getAllEmployeesByHotelName(hotelName),
                HttpStatus.OK
        );
    }
}