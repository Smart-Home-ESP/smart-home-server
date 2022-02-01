package com.smarthome.server.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Document
@Data
@Builder
public class Device extends GenericOwnerItemDto {

    @Id
    private int serial;
    private String deviceName;
    private int hue;
    private int saturation;
    private int brightness;
    private String deviceStatus;
    private String deviceConnectionStatus;
    private String roomID;
    private String deviceType;
}
