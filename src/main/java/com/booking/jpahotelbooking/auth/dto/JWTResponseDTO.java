package com.booking.jpahotelbooking.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor

@Data
public class JWTResponseDTO {

    private String token;
}