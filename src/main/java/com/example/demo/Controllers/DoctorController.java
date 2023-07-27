package com.example.demo.Controllers;

import com.example.demo.Dtos.RequestDtos.AssociateDoctorDto;
import com.example.demo.Models.Doctor;
import com.example.demo.Services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;
    @PostMapping("/addDoctor")
    public String addDoctor(@RequestBody Doctor doctor){
        try{
            String response = doctorService.addDoctor(doctor);
            return response;
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    @PostMapping("/associateWithCenter")
    public ResponseEntity<String> associateDoctor(@RequestBody AssociateDoctorDto associateDoctorDto){
        try{
            String response = doctorService.associateDoctor(associateDoctorDto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
