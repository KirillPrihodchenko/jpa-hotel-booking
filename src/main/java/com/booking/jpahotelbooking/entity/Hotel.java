package com.booking.jpahotelbooking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

@Entity
@Table (
        name = "hotel"
)
public class Hotel {

    @Id
    @GeneratedValue (
            strategy = GenerationType.IDENTITY
    )
    @Column (
            name = "hotel_id",
            nullable = false
    )
    private Long id;

    @Column (
            name = "hotel_name",
            nullable = false
    )
    private String hotelName;

    @Column (
            name = "hotel_location",
            nullable = false
    )
    @Embedded
    private HotelLocation hotelLocation;
}