package com.smarthome.server.repository;

import com.smarthome.server.entity.Scenery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SceneryRepository extends MongoRepository<Scenery, String> {


    List<Scenery> findByRoomID(String roomId);
}
