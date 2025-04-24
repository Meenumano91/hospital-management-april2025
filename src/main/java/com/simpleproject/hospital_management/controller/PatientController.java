package com.simpleproject.hospital_management.controller;

import com.simpleproject.hospital_management.model.Doctor;
import com.simpleproject.hospital_management.model.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/patient/apis")
public class PatientController {
    //Springboot Application- Take input in the form of JSON(JavaScript Object Notation- it is like key value pair

    //Here we are  storing data inside hash map which is in memory

    Map<Integer, Patient> patientMapDb= new HashMap<>();
    //101-->{101,ajay,ajay@gmail.com,cardio,35}
    //102-->{102,sanjay,sanjay@gmail.com,Neuro,32}
    //103-->{103,vijay,vijay@gmail.com,Nephro,45}

    //@RequestBody - it takes the input from the postman or ui and assigns it to the doctor object(used for complete class objects)
    @PostMapping("/save")
    public String savePatient(@RequestBody Patient patient)
    {
        patientMapDb.put(patient.getId(),patient);
        System.out.println("Doctor saved is : "+ patientMapDb);
        return "Patient saved successfully";
    }


    @PostMapping("/saveList")
    public String savePatientList(@RequestBody List<Patient> patientList)
    {
        for(Patient p1:patientList)
        {
            patientMapDb.put(p1.getId(),p1);
        }
        System.out.println("Doctor saved is :"+patientMapDb);
        return "patientList is saved";
    }


    @GetMapping("/findAll")
    public Map<Integer,Patient> getAllPatients()
    {
        return patientMapDb;
    }



    //PathVariable -takes the input in API url path or endpoint
    @GetMapping("findbyId/{id}")
    public Patient getPatientById(@PathVariable int id)
    {
        Patient patient=patientMapDb.get(id);
        return patient;
    }



    @DeleteMapping("/delete/{id}")
    public String deletePatientById(@PathVariable int id)
    {
        patientMapDb.remove(id);
        return "patient deleted Successfully with id : "+id;
    }

}
