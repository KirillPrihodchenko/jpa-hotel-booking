package com.booking.jpahotelbooking.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
        name = "employees",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "employee_passport_info_unique",
                        columnNames = "passport_info"
                )
        }
)
public class Employees {

    @Id
    @Column (
            name = "employee_id",
            nullable = false
    )
    private Long id;

    @ManyToOne
    @JoinColumn (
            name = "hotel_id"
    )
    private Hotel hotel;

    @OneToOne (
            cascade = CascadeType.ALL
    )
    @JoinColumn (
            name = "role_id"
    )
    private Roles roles;

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
            name = "salary"
    )
    private Double salary;

    @Column (
            name = "passport_info",
            nullable = false
    )
    private String passportInfo;
}
