package com.example.demo.Services;

import com.example.demo.Exceptions.CenterAddressNotFoundException;
import com.example.demo.Models.VaccinationCenter;
import com.example.demo.Repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationServiceCenter {
    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    public String addVaccinationCenter(VaccinationCenter vaccinationCenter) throws CenterAddressNotFoundException {
        if(vaccinationCenter.getAddress() == null){
            throw new CenterAddressNotFoundException("Vaccination Center Address is empty");
        }
        vaccinationCenterRepository.save(vaccinationCenter);
        return "Center added successfully with ID: "+ vaccinationCenter.getCenterId()+" and location: " +vaccinationCenter.getAddress();
    }
}
