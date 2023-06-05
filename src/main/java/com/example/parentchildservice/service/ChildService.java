package com.example.parentchildservice.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class ChildService {
    @Autowired
    private UtilityService utils;

    public Map<String, Object> getAllChildDataMap() throws IOException {
        String jsonData = utils.getJsonResourceData("/data/Child.json");

        return new JSONObject(jsonData).toMap();
    }
}
