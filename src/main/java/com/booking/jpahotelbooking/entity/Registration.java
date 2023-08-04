package com.booking.jpahotelbooking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table (
        name = "registration"
)
public class Registration {

    @Id
    @GeneratedValue (
            strategy = GenerationType.IDENTITY
    )
    @Column (
            name = "registration_id"
    )
    private Long id;

    @ManyToMany (
            cascade = CascadeType.ALL
    )
    @JoinColumn (
            name = "guest_id"
    )
    private List<Guests> guests;

    @OneToOne
    @JoinColumn (
            name = "room_id",
            nullable = false
    )
    private Rooms rooms;

    @CreationTimestamp
    @Column (
            name = "ts_check_in"
    )
    private Timestamp tsCheckIn;

    @UpdateTimestamp
    @Column (
            name = "ts_check_out"
    )
    private Timestamp tsCheckOut;

    @ManyToOne
    @JoinColumn (
            name = "hotel_id"
    )
    private Hotel hotel;
}