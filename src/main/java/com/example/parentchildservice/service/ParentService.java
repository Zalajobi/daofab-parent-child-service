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

    public Map<String, Object> getAllParentsMap() throws IOException {
        Utils utils = new Utils();
        String jsonData = utils.getJsonResourceData("/data/Parent.json");

        return new JSONObject(jsonData).toMap();
    }

    public ArrayList<Map<String, Object>> getChildObjects(int parentId) throws IOException {
        Utils utils = new Utils();
        String jsonDataString = utils.getJsonResourceData("/data/Child.json");
        ArrayList<Map<String, Object>> jsonData = new ArrayList<>((Collection) new JSONObject(jsonDataString).toMap().get("data"));
        ArrayList<Map<String, Object>> responseData = new ArrayList<>();

        IntStream.range(0, jsonData.size()).filter(count -> parentId == Integer.parseInt(jsonData.get(count).get("parentId").toString())).mapToObj(jsonData::get).forEach(data -> responseData.add(data));

        return responseData;
    }
}
