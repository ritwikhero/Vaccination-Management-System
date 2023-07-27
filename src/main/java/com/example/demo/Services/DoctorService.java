package com.example.demo.Services;

import com.example.demo.Dtos.RequestDtos.AssociateDoctorDto;
import com.example.demo.Exceptions.CenterNotFoundException;
import com.example.demo.Exceptions.DoctorAlreadyExistsException;
import com.example.demo.Exceptions.DoctorNotFoundException;
import com.example.demo.Exceptions.EmailIdEmptyException;
import com.example.demo.Models.Doctor;
import com.example.demo.Models.VaccinationCenter;
import com.example.demo.Repository.DoctorRepository;
import com.example.demo.Repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private VaccinationCenterRepository vaccinationCenterRepository;

    public String addDoctor(Doctor doctor) throws EmailIdEmptyException, DoctorAlreadyExistsException {

        if(doctor.getEmailId()==null){
            throw new EmailIdEmptyException("Email is mandatory!!!");
        }
        if(doctorRepository.findByEmailId(doctor.getEmailId()) != null){
            throw new DoctorAlreadyExistsException("Doctor with this Email-Id already exists");
        }
        doctorRepository.save(doctor);
        return "Doctor added to the database";
    }

    public String associateDoctor(AssociateDoctorDto associateDoctorDto) throws DoctorNotFoundException, CenterNotFoundException {
        int docId = associateDoctorDto.getDoctorId();

        Optional<Doctor> doctorOptional = doctorRepository.findById(docId);

        if(!doctorOptional.isPresent()){
            throw new DoctorNotFoundException("Doctor with Id "+docId+" is not found ! ");
        }

        int centerId = associateDoctorDto.getCenterId();

        Optional<VaccinationCenter> centerOptional = vaccinationCenterRepository.findById(centerId);

        if(!centerOptional.isPresent()){
            throw new CenterNotFoundException("Center with ID: "+centerId+" not found !");
        }

        Doctor doctor = doctorOptional.get();
        VaccinationCenter vaccinationCenter = centerOptional.get();

        //setting foreign key
        doctor.setVaccinationCenter(vaccinationCenter);

        //Bi-directionally mapping
        //adding this doctor to the list of doctors in the vaccination center model/table
        vaccinationCenter.getDoctorList().add(doctor);
        vaccinationCenterRepository.save(vaccinationCenter);

        return "Doctor has been associated with the Center";
    }
}
