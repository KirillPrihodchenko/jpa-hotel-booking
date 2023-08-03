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
            name = "role_type",
            nullable = false
    )
    private String roleType;

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", role_type='" + roleType + '\'' +
                '}';
    }
}
