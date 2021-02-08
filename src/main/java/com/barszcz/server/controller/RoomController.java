package com.barszcz.server.controller;

import com.barszcz.server.dao.DeviceConfigurationDao;
import com.barszcz.server.dao.RoomConfigurationDao;
import com.barszcz.server.entity.RoomConfigurationModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
public class RoomController {

    private DeviceConfigurationDao deviceConfigurationDao;
    private SimpMessagingTemplate simpMessagingTemplate;
    private RoomConfigurationDao roomConfigurationDao;
    @Autowired
    private ObjectMapper mapper;

    @SubscribeMapping("/rooms")
    public List<RoomConfigurationModel> findRooms() {
        return (List<RoomConfigurationModel>) roomConfigurationDao.findAll();
    }

    @PostMapping(path = "/addRoom")
    public void addRoom(@RequestBody String body) throws JSONException {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(body);
        } catch (JSONException err) {
            System.out.println(err.toString());
        }
        assert jsonObject != null;
        String roomName = (String) jsonObject.get("roomName");
        String main = (String) jsonObject.get("main");
        RoomConfigurationModel roomConfigurationModel = new RoomConfigurationModel();
        roomConfigurationModel.setRoomName(roomName);
        roomConfigurationModel.setMain(main);
        roomConfigurationDao.save(roomConfigurationModel);
        simpMessagingTemplate.convertAndSend("/rooms/rooms", roomConfigurationDao.findAll());
    }

    @PostMapping(path = "/deleteRoom")
    public void deleteDevice(@RequestBody String body) throws JSONException {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(body);
        } catch (JSONException err) {
            System.out.println(err.toString());
        }
        assert jsonObject != null;
        int id = (int) jsonObject.get("id");
        roomConfigurationDao.deleteRoomConfigurationModelByIdLike(id);
        System.out.println("deleted room with id:" + id);
        simpMessagingTemplate.convertAndSend("/rooms/rooms", roomConfigurationDao.findAll());
    }

    public ObjectNode colorChange(String status, int hue, int bright, int sat) {
        ObjectNode objectNode = mapper.createObjectNode();
        objectNode.put("task", "color change");
        objectNode.put("status", status);
        objectNode.put("hue", hue);
        objectNode.put("brightness", bright);
        objectNode.put("saturation", sat);
        return objectNode;
    }

    public ObjectNode responseObject(String response) {
        ObjectNode objectNode = mapper.createObjectNode();
        objectNode.put("response", response);
        return objectNode;
    }
    public ObjectNode roomResponse() {
        ObjectNode objectNode = mapper.createObjectNode();
        objectNode.put("main", roomConfigurationDao.findRoomConfigurationModelByMainLike("yes").toString());
        objectNode.put("rest", roomConfigurationDao.findRoomConfigurationModelsByMainLike("no").toString());
        return objectNode;
    }


}
