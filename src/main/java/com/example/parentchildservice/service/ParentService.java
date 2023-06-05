package com.example.parentchildservice.service;

import org.json.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
public class ParentService {

    public Map<String, Object> getAllParentsMap() throws IOException {
        ClassPathResource staticDataResource = new ClassPathResource("/data/Parent.json");
        String staticDataString = IOUtils.toString(staticDataResource.getInputStream(), StandardCharsets.UTF_8);

        return new JSONObject(staticDataString).toMap();
    }
}
