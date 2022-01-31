package com.smarthome.server.entity;

import com.smarthome.server.entity.enums.ERole;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
public class Role {

    @Id
    private String id;

    private ERole name;

}
