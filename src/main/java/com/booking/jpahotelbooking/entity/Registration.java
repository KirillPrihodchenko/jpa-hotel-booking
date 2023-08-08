package com.booking.jpahotelbooking.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
    private Hotel hotel;
}