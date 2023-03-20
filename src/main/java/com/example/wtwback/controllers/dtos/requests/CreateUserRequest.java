package com.example.wtwback.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateUserRequest {
    private String name;
    private String email;
    private String password;
    private String lastName;
}
