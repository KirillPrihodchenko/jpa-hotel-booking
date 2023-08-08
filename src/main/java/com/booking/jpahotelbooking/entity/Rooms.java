package com.booking.jpahotelbooking.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
        name = "rooms",
        uniqueConstraints = {
                @UniqueConstraint(name = "room_name_unique",
                        columnNames = "room_name"
                )
        }
)
public class Rooms {

    @Id
    @GeneratedValue (
            strategy = GenerationType.IDENTITY
    )
    @Column (
            name = "room_id",
            nullable = false
    )
    private Long id;

    @OneToOne (
            cascade = CascadeType.ALL
    )
    @JoinColumn (
            name = "room_type_id",
            nullable = false
    )
    private RoomsType roomsType;

    @OneToOne (
            cascade = CascadeType.ALL
    )
    @JoinColumn (
            name = "room_status_id",
            nullable = false
    )
    private RoomsStatus roomsStatus;

    @Column (
            name = "room_capacity",
            nullable = false
    )
    private Integer roomCapacity;

    @Column (
            name = "room_name",
            nullable = false
    )
    private Integer roomName;

    @Column (
            name = "room_price"
    )
    private Double roomPrice;

    @OneToOne
    private Registration registration;
}