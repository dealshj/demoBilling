package com.example.demo.beans;


import com.example.demo.enums.UserTypes;

import java.time.LocalDateTime;

public final class UserDetails {
    private final UserTypes userType;
    private final LocalDateTime userSince;

    public UserDetails( UserTypes userType, LocalDateTime userSince) {

        this.userType = userType;
        this.userSince = userSince;
    }

    public UserTypes getUserType() {
        return userType;
    }

    public LocalDateTime getUserSince() {
        return userSince;
    }



    @Override
    public String toString() {
        return "UserDetails{" +
                ", userType=" + userType +
                ", userSince=" + userSince +
                '}';
    }
}
