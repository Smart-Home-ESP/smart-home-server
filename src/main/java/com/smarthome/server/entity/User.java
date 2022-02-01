package com.smarthome.server.entity;

import java.util.HashSet;
import java.util.Set;


import com.smarthome.server.entity.enums.Role;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
public class User {
    @Id
    private String id;
    private String username;
    private String email;
    private String password;
    private Set<Role> roles = new HashSet<>();

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}