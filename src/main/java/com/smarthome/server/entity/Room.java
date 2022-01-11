package com.smarthome.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
public class Room {

    @Id
    private String id;
    private String roomName;
    private boolean main;
}
