package com.example.demo.Services;


import com.example.demo.Models.Dose;
import com.example.demo.Models.User;
import com.example.demo.Repository.DoseRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoseService {

    @Autowired
    DoseRepository doseRepository;

    @Autowired
    UserRepository userRepository;

    public String giveDose(String doseId,Integer userId){
        User user = userRepository.findById(userId).get();

        Dose dose = new Dose();
        // set attributes
        dose.setDoseId(doseId);
        dose.setUser(user);
//        save entity
//        doseRepository.save(dose);

        //setting the child object in the corresponding
        user.setDose(dose);

        userRepository.save(user);
        // child will automatically get saved because of cascading effect

        return "Dose-1 given to user sucessfully ";

    }
}
