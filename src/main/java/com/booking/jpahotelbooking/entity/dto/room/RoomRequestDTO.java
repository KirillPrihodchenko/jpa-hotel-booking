package com.booking.jpahotelbooking.entity.dto.room;

import com.booking.jpahotelbooking.entity.RoomType;

import lombok.Data;

@Data
public class RoomRequestDTO {

    private RoomType roomsType;
    private Integer roomName;
    private Double roomPrice;
    private Integer roomCapacity;
    private Boolean status;
}