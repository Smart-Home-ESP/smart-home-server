package com.barszcz.server.entity.Responses;

import lombok.Data;

@Data
public class TemperatureChangeResponse {

    private String task;
    private int serial;
    private String temperature;
    private String humidity;


    public TemperatureChangeResponse(int serial, String temperature, String humidity) {
        this.task = "temperature change";
        this.serial = serial;
        this.temperature = temperature;
        this.humidity = humidity;
    }
}
