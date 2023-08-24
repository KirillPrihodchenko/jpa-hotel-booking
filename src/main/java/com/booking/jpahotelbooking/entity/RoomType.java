package com.booking.jpahotelbooking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
        name = "rooms_type"
)
public class RoomType {

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

//    @OneToOne
//    private Room rooms;
}