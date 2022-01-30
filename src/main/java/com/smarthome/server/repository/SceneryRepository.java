package com.smarthome.server.repository;

import com.smarthome.server.entity.Scenery;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface SceneryRepository extends MongoRepository<Scenery, String> {


    List<Scenery> findByRoomID(String roomId);
}
