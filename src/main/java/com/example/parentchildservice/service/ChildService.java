package com.example.parentchildservice.service;

import com.example.parentchildservice.helper.Utils;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class ChildService {

    public Map<String, Object> getAllChildDataMap() throws IOException {
        Utils utils = new Utils();
        String jsonData = utils.getJsonResourceData("/data/Child.json");

        return new JSONObject(jsonData).toMap();
    }
}
