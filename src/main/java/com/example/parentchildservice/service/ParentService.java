package com.example.parentchildservice.service;

import com.example.parentchildservice.helper.Utils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.IntStream;

@Service
public class ParentService {

//    Get All Parent Data
    public Map<String, Object> getAllParentsMap() throws IOException {
        Utils utils = new Utils();
        String jsonData = utils.getJsonResourceData("/data/Parent.json");

        return new JSONObject(jsonData).toMap();
    }

}
