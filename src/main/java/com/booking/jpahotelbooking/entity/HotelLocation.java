package com.booking.jpahotelbooking.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Embeddable
public class HotelLocation {

    private String country;
    private String region;
    private String city;
    private String address;
}