package com.booking.jpahotelbooking.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Embedded;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import lombok.ToString;
import lombok.Getter;
import lombok.Setter;

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

    @ManyToOne
    @JoinColumn (
            name = "registration_id"
    )
    private Registration registration;

    @Column (
            name = "hotel_location",
            nullable = false
    )
    @Embedded
    private HotelLocation hotelLocation;
}