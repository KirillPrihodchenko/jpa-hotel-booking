package com.booking.jpahotelbooking.entity.dto.room;

import com.booking.jpahotelbooking.entity.RoomsType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

@Data
public class RoomsDTO {

    @NotNull
    private RoomsType roomsType;
    @NotNull
    private Integer roomName;
    @NotNull
    private Double roomPrice;
}
