package com.booking.jpahotelbooking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

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

    @Override
    public String toString() {
        return "RoomsStatus{" +
                "id=" + id +
                ", roomStatus=" + roomStatus +
                '}';
    }
}
