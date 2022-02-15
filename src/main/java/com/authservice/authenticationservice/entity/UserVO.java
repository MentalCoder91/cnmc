package com.authservice.authenticationservice.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserVO {


    private String username;
    private String password;
    private String ssaId;
    private String circleId;

    public UserVO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}