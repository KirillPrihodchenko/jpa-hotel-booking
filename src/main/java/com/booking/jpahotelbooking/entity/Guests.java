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
        name = "guests",
        uniqueConstraints = {
                @UniqueConstraint(name = "passport_info", columnNames = "passport_info")
        }
)
public class Guests {

    @Id
    @Column (
            name = "guest_id",
            nullable = false
    )
    @GeneratedValue (
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column (
            name = "first_name",
            nullable = false
    )
    private String firstName;

    @Column (
            name = "last_name",
            nullable = false
    )
    private String lastName;

    @Column (
            name = "phone"
    )
    private String phone;

    @Column (
            name = "passport_info",
            nullable = false
    )
    private String passportInfo;
}
