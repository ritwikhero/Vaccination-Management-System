package com.example.demo.Controllers;

import com.example.demo.Dtos.RequestDtos.AppointmentRequestDto;
import com.example.demo.Services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;
    @PostMapping("/book")
    public String bookAppointment(@RequestBody AppointmentRequestDto appointmentRequestDto){
        try{
            String response = appointmentService.bookAppointment(appointmentRequestDto);
            return response;
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
}
