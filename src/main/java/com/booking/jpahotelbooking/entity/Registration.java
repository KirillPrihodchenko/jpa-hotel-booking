package com.booking.jpahotelbooking.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import lombok.ToString;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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

    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn (
            name = "guest_id"
    )
    private Guest guests;

    @OneToOne
    @JoinColumn (
            name = "room_id",
            referencedColumnName = "room_id",
            nullable = false
    )
    private Room rooms;

    @CreationTimestamp
    @Column (
            name = "ts_check_in"
    )
    private LocalDateTime tsCheckIn;

    @UpdateTimestamp
    @Column (
            name = "ts_check_out"
    )
    private LocalDateTime tsCheckOut;
}