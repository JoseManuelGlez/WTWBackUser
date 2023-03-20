package com.example.wtwback.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ValidateUserResponse {
    private String id;
    private String name;
    private String email;
    private String password;
    private String lastName;
}
