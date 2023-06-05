package com.example.parentchildservice.controllers;

import com.example.parentchildservice.response.ParentResponse;
import com.example.parentchildservice.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

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
    public ParentResponse getAllParentsData(@RequestParam("page") Integer page) {
        try {
            ArrayList<Object> jsonArray = new ArrayList<>((Collection) parentService.getAllParentsMap().get("data"));
            int fromPage = page * 2;
            int toPage = (page * 2) + 2 > jsonArray.size() ? jsonArray.size() : (page * 2) + 2;

            return new ParentResponse(jsonArray.subList(fromPage, toPage), jsonArray.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}