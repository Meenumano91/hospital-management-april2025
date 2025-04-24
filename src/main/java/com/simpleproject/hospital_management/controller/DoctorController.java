package com.simpleproject.hospital_management.controller;


import com.simpleproject.hospital_management.model.Doctor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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

    //@RequestBody - it takes the input from the postman or ui and assigns it to the doctor object(used for complete class objects)
    @PostMapping("/save")
    public String saveDoctor(@RequestBody Doctor doctor)
    {
     doctorMapDb.put(doctor.getId(),doctor);
        System.out.println("Doctor saved is : "+ doctorMapDb);
        return "Doctor saved successfully";
    }


    @PostMapping("/saveList")
    public String saveDoctorList(@RequestBody List<Doctor> doctorList)
    {
        for(Doctor d1:doctorList)
        {
            doctorMapDb.put(d1.getId(),d1);
        }
        System.out.println("Doctor saved is :"+doctorMapDb);
        return "DoctorList is saved";
    }


    @GetMapping("/findAll")
    public Map<Integer,Doctor> getAllDoctors()
    {
        return doctorMapDb;
    }



    //PathVariable -takes the input in API url path or endpoint
    @GetMapping("findbyId/{id}")
    public Doctor getDoctorById(@PathVariable int id)
    {
        Doctor doctor=doctorMapDb.get(id);
        return doctor;
    }



    @DeleteMapping("/delete/{id}")
    public String deleteDoctorById(@PathVariable int id)
    {
        doctorMapDb.remove(id);
        return "Doctor deleted Successfully with id : "+id;
    }


}
