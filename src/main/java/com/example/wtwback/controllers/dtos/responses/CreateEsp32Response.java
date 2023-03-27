package com.example.wtwback.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateEsp32Response {
    private Long id;
    private String keyEsp32;
    private String type;
    private Long userId;
}
