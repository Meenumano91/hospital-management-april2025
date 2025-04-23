package com.simpleproject.hospital_management.controller;


import com.simpleproject.hospital_management.model.Doctor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/doctor/apis")
public class DoctorController {

    //Springboot Application- Take input in the form of JSON(JavaScript Object Notation- it is like key value pair

    //Here we are  storing data inside hash map which is in memory

    Map<Integer, Doctor> doctorMapDb= new HashMap<>();
    //101-->{101,ajay,ajay@gmail.com,cardio,35}
    //102-->{102,sanjay,sanjay@gmail.com,Neuro,32}
    //103-->{103,vijay,vijay@gmail.com,Nephro,45}


    @PostMapping("/save")
    public String saveDoctor(@RequestBody Doctor doctor)
    {
     doctorMapDb.put(doctor.getId(),doctor);
        System.out.println("Doctor saved is : "+ doctorMapDb);
        return "Doctor saved successfully";
    }


}
