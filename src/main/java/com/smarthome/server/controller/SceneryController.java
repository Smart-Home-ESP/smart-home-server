package com.smarthome.server.controller;

import com.smarthome.server.entity.Scenery;
import com.smarthome.server.exception.UnauthorizedException;
import com.smarthome.server.repository.SceneryRepository;
import com.smarthome.server.service.DeviceService;
import com.smarthome.server.utils.AuthUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.smarthome.server.utils.AuthUtils.authBelongsCheck;
import static com.smarthome.server.utils.AuthUtils.authUsername;


@RestController
@AllArgsConstructor
@RequestMapping("/scenery")
public class SceneryController {

    private final SceneryRepository sceneryRepository;
    private final DeviceService deviceService;


    @GetMapping("/{roomId}")
    public List<Scenery> getAllSceneryByRoomId(@PathVariable String roomId) {
        return sceneryRepository.findByRoomID(roomId)
                .stream()
                .filter(AuthUtils::authBelongsCheck)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<Boolean> addScenery(@RequestBody Scenery scenery) {
        scenery.setId(UUID.randomUUID().toString());
        scenery.setOwners(Set.of(authUsername()));
        sceneryRepository.save(scenery);

        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PostMapping("/execute/{id}")
    public ResponseEntity<Boolean> executeScenery(@PathVariable String id) {
        sceneryRepository.findById(id)
                .filter(AuthUtils::authBelongsCheck)
                .ifPresentOrElse(scenery -> scenery.getDevices()
                        .forEach(device -> {
                            try {
                                deviceService.changeDeviceStatusAndColor(device);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }), () -> {
                    throw new UnauthorizedException("User is not owner of this scenery");
                });
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Boolean> editScenery(@RequestBody Scenery scenery) {
        //TODO make it better
        if (authBelongsCheck(scenery)) {
            sceneryRepository.save(scenery);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        sceneryRepository.findById(id)
                .filter(AuthUtils::authBelongsCheck)
                .ifPresentOrElse(scenery -> sceneryRepository.deleteById(id),
                        () -> {
                            throw new UnauthorizedException("User is not owner of this scenery");
                        });

        return new ResponseEntity<>(true, HttpStatus.OK);
    }


}
