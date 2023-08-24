package com.booking.jpahotelbooking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

@Entity
@Table (
        name = "guests",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "guest_passport_info_unique",
                        columnNames = "passport_info"
                )
        }
)
public class Guest {

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
