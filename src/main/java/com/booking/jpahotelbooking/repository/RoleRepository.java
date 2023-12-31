package com.booking.jpahotelbooking.repository;

import com.booking.jpahotelbooking.entity.Role;
import com.booking.jpahotelbooking.entity.eRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRoleType(eRole eRole);
}