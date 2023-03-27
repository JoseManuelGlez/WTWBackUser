package com.example.wtwback.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateMonitoringInformationRequest {
    private String date;
    private String hour;
    private String soilTemperature;
    private String soilHumidity;
    private String ambientTemperature;
    private String ambientHumidity;
    private Long espId;
    private String type;
}
