package com.example.parentchildservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
public class ParentService {

//    public Object[] getAllParentsMap() throws IOException {
    public Map<String, Object> getAllParentsMap() throws IOException {
        ClassPathResource dataResource = new ClassPathResource("/data/Parent.json");

        String jsonData = IOUtils.toString(dataResource.getInputStream(), StandardCharsets.UTF_8);

        ObjectMapper objectMapper = new ObjectMapper();

        return new JSONObject(jsonData).toMap();
    }
}
