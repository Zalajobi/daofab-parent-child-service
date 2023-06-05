package com.example.parentchildservice.service;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.IntStream;

@Service
public class UtilityService {
    public String getJsonResourceData(String route) {
        try {
            ClassPathResource dataResource = new ClassPathResource(route);
            return IOUtils.toString(dataResource.getInputStream(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Map<String, Object>> getChildObjects(int parentId) throws IOException {
        UtilityService utils = new UtilityService();
        String jsonDataString = utils.getJsonResourceData("/data/Child.json");
        ArrayList<Map<String, Object>> jsonData = new ArrayList<>((Collection) new JSONObject(jsonDataString).toMap().get("data"));
        ArrayList<Map<String, Object>> responseData = new ArrayList<>();

        IntStream.range(0, jsonData.size()).filter(count -> parentId == Integer.parseInt(jsonData.get(count).get("parentId").toString())).mapToObj(jsonData::get).forEach(data -> responseData.add(data));

        return responseData;
    }
}
