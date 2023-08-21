package com.booking.jpahotelbooking.entity.dto.room;

import com.booking.jpahotelbooking.entity.RoomsType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RoomsResponseDTO {

    @NotNull
    private RoomsType roomsType;
    @NotNull
    private Integer roomName;
    @NotNull
    private Double roomPrice;
}