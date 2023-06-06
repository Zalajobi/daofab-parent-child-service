package com.example.parentchildservice.service;

import com.example.parentchildservice.helper.Utils;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.IntStream;

@Service
public class UtilityService {
    // get all children of a parent ID
    public ArrayList<Map<String, Object>> getChildObjects(int parentId) {
        ArrayList<Map<String, Object>> responseData = new ArrayList<>();
        try {
            Utils utils = new Utils();
            // Get the file data as string by passing the string route relative to the resource folder
            String jsonDataString = utils.getJsonResourceData("/data/Child.json");
            ArrayList<Map<String, Object>> jsonData = new ArrayList<>((Collection) new JSONObject(jsonDataString).toMap().get("data"));

            // Iterate and Add child object to response data when parentId of child object is same as the required parent ID
            IntStream.range(0, jsonData.size()).filter(count -> parentId == Integer.parseInt(jsonData.get(count).get("parentId").toString())).mapToObj(jsonData::get).forEach(data -> responseData.add(data));
        } catch (Exception e) {
          System.out.println(e);
        }

        return responseData;
    }
}
