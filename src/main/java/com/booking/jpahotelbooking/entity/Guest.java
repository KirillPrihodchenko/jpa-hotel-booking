package com.booking.jpahotelbooking.entity;

import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import lombok.ToString;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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
                ),
                @UniqueConstraint(
                        name = "guest_email_unique",
                        columnNames = "email"
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
            name = "email",
            nullable = false
    )
    @Pattern(
            regexp = "[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+@gmail\\.com"
    )
    private String email;

    @Column (
            name = "password",
            nullable = false
    )
    private String password;

    @Column (
            name = "passport_info",
            nullable = false
    )
    private String passportInfo;
}