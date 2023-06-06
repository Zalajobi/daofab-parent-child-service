package com.example.parentchildservice.controllers;

import com.example.parentchildservice.service.UtilityService;
import com.example.parentchildservice.response.ParentResponse;
import com.example.parentchildservice.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static com.example.parentchildservice.helper.Constants.BASE_URL;

@RestController
@RequestMapping(BASE_URL + "/parent")
public class ParentController {

    @Autowired
    private ParentService parentService;

    @Autowired
    private UtilityService utilityService;


    // Parent route controller, manages pagination also
    @GetMapping("/paginate")
    public ParentResponse getAllParentsData(@RequestParam("page") Integer page) {
        try {
            ArrayList<Map<String, Object>> jsonArray = new ArrayList<>((Collection) parentService.getAllParentsMap().get("data"));

            // Paginate the data
            int fromPage = page * 2;
            int toPage = (page * 2) + 2 > jsonArray.size() ? jsonArray.size() : (page * 2) + 2;

            List<Map<String, Object>> paginatedData = jsonArray.subList(fromPage, toPage);

            // Get all the child Objects of each parent and attach to each as a new key value with key of "child"
            paginatedData.stream().forEach(item -> item.put("child", utilityService.getChildObjects(Integer.valueOf(item.get("id").toString()))));

            // Return the split data
            return new ParentResponse(paginatedData, jsonArray.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}