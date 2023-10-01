package com.booking.jpahotelbooking.entity.dto.registration;

import com.booking.jpahotelbooking.entity.Room;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegistrationRequestDTO {

    private Room rooms;
    private LocalDateTime tsCheckIn;
    private LocalDateTime tsCheckOut;
}