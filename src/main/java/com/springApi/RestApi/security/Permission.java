package com.springApi.RestApi.security;

public enum Permission {

    PUBLIC_READ("public:read"),
    PUBLIC_WRITE("public:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
