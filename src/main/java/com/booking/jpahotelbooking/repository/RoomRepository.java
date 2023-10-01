package com.booking.jpahotelbooking.repository;

import com.booking.jpahotelbooking.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    @Modifying
    @Query("UPDATE Room r SET r.roomsStatus = :status WHERE r.id = :id")
    Room updateStatusForRoom(@Param("id") Long id, @Param("status") Boolean status);
}