package com.example.parentchildservice.service;

import com.example.parentchildservice.helper.Utils;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

@Service
public class ChildService {

    public Map<String, Object> getParentDataById(int id) throws IOException {
        Utils utils = new Utils();
        String jsonDataString = utils.getJsonResourceData("/data/Parent.json");
        ArrayList<Map<String, Object>> jsonData = new ArrayList<>((Collection) new JSONObject(jsonDataString).toMap().get("data"));

        Map<String, Object> responseData = new HashMap<>();

        IntStream.range(0, jsonData.size()).filter(count -> id == Integer.valueOf(jsonData.get(count).get("id").toString())).mapToObj(jsonData::get).forEach(data -> responseData.put("parent", data));

        return responseData;
    }
}
