package com.example.parentchildservice.controllers;

import com.example.parentchildservice.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

import static com.example.parentchildservice.helper.Constants.BASE_URL;

@RestController
@RequestMapping(BASE_URL + "/parent")
public class ParentController {

    @Autowired
    private ParentService parentService;

    @GetMapping("/")
    public String welcome() {
        return "HELLO WORLD";
    }

    @GetMapping("/all")
    public Map<String, Object> getAllParentsData() {
        try {
            return parentService.getAllParentsMap();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}