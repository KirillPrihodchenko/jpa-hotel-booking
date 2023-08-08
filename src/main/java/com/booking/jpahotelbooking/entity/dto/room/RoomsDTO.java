package com.booking.jpahotelbooking.entity.dto.room;

import com.booking.jpahotelbooking.entity.RoomsType;
import lombok.Data;

@Data
public class RoomsDTO {

    private RoomsType roomsType;
    private Integer roomCapacity;
    private Integer roomName;
    private Double roomPrice;
}
