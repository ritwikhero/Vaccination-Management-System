package com.example.demo.Controllers;

import com.example.demo.Models.VaccinationCenter;
import com.example.demo.Services.VaccinationServiceCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vaccinationCenter")
public class VaccinationCenterController {

    @Autowired
    VaccinationServiceCenter vaccinationServiceCenter;
    @PostMapping("/addVaccinationCenter")
    public ResponseEntity<String> addVaccinationCenter(@RequestBody VaccinationCenter vaccinationCenter){
        try{
            String response = vaccinationServiceCenter.addVaccinationCenter(vaccinationCenter);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
