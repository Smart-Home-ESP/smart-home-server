package com.smarthome.server.entity;

import lombok.Data;

import java.util.Set;

@Data
public class GenericOwnerItemDto {
    private Set<String> owners;
}
