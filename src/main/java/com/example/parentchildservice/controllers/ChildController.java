package com.example.parentchildservice.controllers;

import com.example.parentchildservice.response.ChildResponse;
import com.example.parentchildservice.service.ChildService;
import com.example.parentchildservice.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.example.parentchildservice.helper.Constants.BASE_URL;

@RestController
@RequestMapping(BASE_URL + "/child")
public class ChildController {

    @Autowired
    private ChildService childService;

    @Autowired
    private UtilityService utilityService;

//    Child Conntroller
    @GetMapping("/")
    public ChildResponse getAllChildComponent(@RequestParam("parentId") Integer parentId) throws IOException {

        // Get Child information and Parent data also
        List<Map<String, Object>> childData = utilityService.getChildObjects(parentId);

        return new ChildResponse(childData, childData.size(), childService.getParentDataById(parentId).get("parent"));
    }
}
