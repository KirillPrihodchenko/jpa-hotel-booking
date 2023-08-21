package com.booking.jpahotelbooking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
        name="roles"
)
public class Roles {

    @Id
    @GeneratedValue (
            strategy = GenerationType.IDENTITY
    )
    @Column (
            name = "role_id",
            nullable = false
    )
    private Long id;

    @Column (
            name = "role_name",
            nullable = false
    )
    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    @OneToOne
    private Employees employees;

    public enum RoleName {
        ADMIN, MANAGER, USER
    }
}