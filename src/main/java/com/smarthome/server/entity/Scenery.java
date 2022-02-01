package com.smarthome.server.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Document
@Data
public class Scenery extends GenericOwnerItemDto {

    @Id
    private String id;
    private String roomID;
    private String sceneryName;
    private String sceneryLogo;
    private List<Device> devices;

}
