package com.booking.jpahotelbooking.entity.dto.room;

import com.booking.jpahotelbooking.entity.RoomType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RoomResponseDTO {

    @NotNull
    private RoomType roomsType;
    @NotNull
    private Integer roomName;
    @NotNull
    private Double roomPrice;
}