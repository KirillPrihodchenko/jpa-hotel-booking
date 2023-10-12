package com.booking.jpahotelbooking.entity;

import jakarta.validation.constraints.Pattern;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
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
    @Pattern (
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
            name = "passport_info",
            nullable = false
    )
    @Pattern(
            regexp = "^\\d{9}$"
    )
    private String passportInfo;

    @ManyToMany
    @JoinTable(
            name = "guest_roles",
            joinColumns = @JoinColumn(name = "guest_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> role;
}