package com.example.parentchildservice.controllers;

import com.example.parentchildservice.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChildController {

    @Autowired
    private ChildService childService;
}
