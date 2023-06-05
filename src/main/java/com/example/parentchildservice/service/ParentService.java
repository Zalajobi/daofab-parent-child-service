package com.example.parentchildservice.service;

import com.example.parentchildservice.helper.Utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Map;

@Service
public class ParentService {

//    public Object[] getAllParentsMap() throws IOException {
    public Map<String, Object> getAllParentsMap() throws IOException {
        Utils utils = new Utils();
        String jsonData = utils.getJsonResourceData("/data/Parent.json");

        return new JSONObject(jsonData).toMap();
    }

//    public ArrayList<Object> getChildObjects() throws IOException {
//        ClassPathResource dataResource = new ClassPathResource("/data/Parent.json");
//    }
}
