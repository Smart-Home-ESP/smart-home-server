package com.smarthome.server.repository;

import com.smarthome.server.entity.UnassignedDevice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnassignedDeviceRepository extends MongoRepository<UnassignedDevice, Integer> {
}
