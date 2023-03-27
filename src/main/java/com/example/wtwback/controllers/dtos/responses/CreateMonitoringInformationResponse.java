package com.example.wtwback.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateMonitoringInformationResponse {
    private Long id;
    private String date;
    private String hour;
    private String soilTemperature;
    private String soilHumidity;
    private String ambientTemperature;
    private String ambientHumidity;
    private Long espId;
    private String type;
}
