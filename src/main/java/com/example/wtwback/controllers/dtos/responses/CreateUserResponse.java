package com.example.wtwback.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class CreateUserResponse {
    private String id;
    private String name;
    private String email;
    private String password;
    private String lastName;
}
