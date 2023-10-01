package com.booking.jpahotelbooking.entity.dto.room;

import com.booking.jpahotelbooking.entity.RoomType;
import lombok.Data;

@Data
public class RoomResponseDTO {

    private RoomType roomsType;
    private Integer roomName;
    private Double roomPrice;
}