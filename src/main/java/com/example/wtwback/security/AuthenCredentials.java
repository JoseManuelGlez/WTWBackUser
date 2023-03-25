package com.example.wtwback.security;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class AuthenCredentials {
    private String email;
    private String password;
}
