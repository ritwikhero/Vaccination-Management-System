package com.example.demo.Services;

import com.example.demo.Dtos.RequestDtos.AppointmentRequestDto;
import com.example.demo.Exceptions.DoctorNotFoundException;
import com.example.demo.Exceptions.UserNotFoundException;
import com.example.demo.Models.Appointment;
import com.example.demo.Models.Doctor;
import com.example.demo.Models.User;
import com.example.demo.Repository.AppointmentRepository;
import com.example.demo.Repository.DoctorRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private UserRepository userRepository;

    public String bookAppointment(AppointmentRequestDto appointmentRequestDto) throws DoctorNotFoundException, UserNotFoundException {

        Optional<Doctor> doctorOptional = doctorRepository.findById(appointmentRequestDto.getDoctorId());

        if (!doctorOptional.isPresent()){
            throw new DoctorNotFoundException("Doctor not found with the given ID");
        }

        Optional<User> userOptional = userRepository.findById(appointmentRequestDto.getUserId());

        if(!userOptional.isPresent()){
            throw  new UserNotFoundException("User not found with the given ID");
        }
        Doctor doctor = doctorOptional.get();
        User user = userOptional.get();

        Appointment appointment = new Appointment();

        //creating object and setting its attributes
        appointment.setAppointmentDate(appointmentRequestDto.getAppointmentDate());
        appointment.setAppointmentTime(appointmentRequestDto.getAppointmentTime());

        //Setting foreign keys
        appointment.setDoctor(doctor);
        appointment.setUser(user);

        //saving it so I can get the PK from appointment Table
        appointment = appointmentRepository.save(appointment);

        doctor.getAppointmentList().add(appointment);
        user.getAppointmentList().add(appointment);

        doctorRepository.save(doctor);
        userRepository.save(user);

        return "Appointment booked successfully";

    }
}
