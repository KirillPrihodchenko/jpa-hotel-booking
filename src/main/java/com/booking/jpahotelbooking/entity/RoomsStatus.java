package com.booking.jpahotelbooking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table (
        name = "rooms_status"
)
public class RoomsStatus {

    @Id
    @GeneratedValue (
            strategy = GenerationType.IDENTITY
    )
    @Column (
            name = "room_status_id",
            nullable = false
    )
    private Long id;

    @Column (
            name = "room_status",
            nullable = false
    )
    private Boolean roomStatus;

    @OneToOne
    private Rooms rooms;
}
