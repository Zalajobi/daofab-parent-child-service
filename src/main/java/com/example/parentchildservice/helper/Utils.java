package com.example.parentchildservice.helper;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Utils {
    public String getJsonResourceData(String route) {
        try {
            ClassPathResource dataResource = new ClassPathResource(route);
            return IOUtils.toString(dataResource.getInputStream(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
