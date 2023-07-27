package com.example.demo.Services;

import com.example.demo.Dtos.RequestDtos.UpdateEmailDto;
import com.example.demo.Models.Dose;
import com.example.demo.Models.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User addUser(User user){
        user = userRepository.save(user);
        return user;
    }

    public Date getVaccinationDate(Integer userId){
        User user = userRepository.findById(userId).get();

        Dose dose = user.getDose();

        return dose.getVaccinationDate();
    }

    public String updateEmail(UpdateEmailDto updateEmailDto) {
        int userId = updateEmailDto.getUserId();

        User user = userRepository.findById(userId).get();

        user.setEmailId(updateEmailDto.getNewEmailId());

        userRepository.save(user);

        return "Old email has been updated to a new email: "+updateEmailDto.getNewEmailId();
    }

    public User getUserByEmail(String email) {
        User user = userRepository.findByEmailId(email);
        return user;
    }
}
