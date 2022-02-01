package com.smarthome.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Document
@Data
@AllArgsConstructor
public class Room extends GenericOwnerItemDto {

    @Id
    private String id;
    private String roomName;
    private boolean main;
}
