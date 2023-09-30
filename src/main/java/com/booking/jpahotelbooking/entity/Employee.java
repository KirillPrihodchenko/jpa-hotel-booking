package com.booking.jpahotelbooking.entity;

import jakarta.validation.constraints.Pattern;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import jakarta.persistence.Table;
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
        name = "employees",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "employee_passport_info_unique",
                        columnNames = "passport_info"
                ),
                @UniqueConstraint(
                        name = "employee_email_unique",
                        columnNames = "email"
                )
        }
)
public class Employee {

    @Id
    @GeneratedValue (
            strategy = GenerationType.IDENTITY
    )
    @Column (
            name = "employee_id",
            nullable = false
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

    @ManyToOne
    @JoinColumn (
            name = "hotel_id"
    )
    private Hotel hotel;

    @ManyToOne (
            cascade = CascadeType.ALL
    )
    @JoinColumn (
            name = "role_id"
    )
    private Role role;


    @Column (
            name = "salary"
    )
    private Double salary;

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
            name = "phone"
    )
    private String phone;

    @Column (
            name = "passport_info",
            nullable = false
    )
    private String passportInfo;
}