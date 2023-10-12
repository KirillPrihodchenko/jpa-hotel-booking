package com.booking.jpahotelbooking.entity;

public enum eRole {

    ROLE_USER("USER"),
    ROLE_MODERATOR("MODERATOR"),
    ROLE_ADMIN("ADMIN");

    private String roleProperty;

    eRole(String roleProperty) {
        this.roleProperty = roleProperty;
    }

    public String extractRoleProperty() {
        return this.roleProperty;
    }
}