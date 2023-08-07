package com.booking.jpahotelbooking.mapper;

public interface GenericMapper<DTO, E> {

    DTO convertToDto(E entity);
}
