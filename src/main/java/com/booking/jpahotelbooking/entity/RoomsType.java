package com.booking.jpahotelbooking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table (
        name = "rooms_type"
)
public class RoomsType {

    @Id
    @Column (
            name = "room_type_id",
            nullable = false
    )
    @GeneratedValue (
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column (
            name = "room_type",
            nullable = false
    )
    private String roomType;
}
