package com.simpleproject.hospital_management.controller;


import com.simpleproject.hospital_management.model.Doctor;
import com.simpleproject.hospital_management.model.Ward;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ward/apis")
public class WardController {

    Map<Integer, Ward> wardMapDb= new HashMap<>();


    @PostMapping("/save")
    public String save(@RequestBody Ward ward)
    {
        wardMapDb.put(ward.getId(),ward);
        System.out.println("Ward saved is : "+ wardMapDb);
        return "Ward saved successfully";
    }

    @PostMapping("/saveList")
    public String saveWardList(@RequestBody List<Ward> wardList)
    {
        for(Ward w1:wardList)
        {
            wardMapDb.put(w1.getId(),w1);
        }
        System.out.println("Doctor saved is :"+wardMapDb);
        return "WardList is saved";
    }


}
