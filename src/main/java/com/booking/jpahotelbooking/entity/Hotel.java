package com.booking.jpahotelbooking.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

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
    @Column (
            name = "hotel_id",
            nullable = false
    )
    private Long id;

    @OneToMany (
            cascade = CascadeType.ALL
    )
    @JoinColumn (
            name = "registration_id"
    )
    private List<Registration> registration;

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

    @OneToMany (
            cascade = CascadeType.ALL
    )
    private List<Employees> employees;
}