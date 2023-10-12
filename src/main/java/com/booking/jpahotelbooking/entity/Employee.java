package com.booking.jpahotelbooking.entity;

import jakarta.validation.constraints.Pattern;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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

import java.util.Set;

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

    @ManyToMany
    @JoinTable(
            name = "employee_roles",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> role;


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
    @Pattern(
            regexp = "^(?=.*[A-Z]).{8,}$"
    )
    private String password;

    @Column (
            name = "phone"
    )
    private String phone;

    @Column (
            name = "passport_info"
    )
    @Pattern(
            regexp = "^\\d{9}$"
    )
    private String passportInfo;
}