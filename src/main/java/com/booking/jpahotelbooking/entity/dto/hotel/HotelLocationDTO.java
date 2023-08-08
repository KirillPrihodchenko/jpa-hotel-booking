package com.booking.jpahotelbooking.entity.dto.hotel;

import lombok.Data;

@Data
public class HotelLocationDTO {

    private String country;
    private String region;
    private String city;
    private String address;
}