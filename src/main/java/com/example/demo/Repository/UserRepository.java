package com.example.demo.Repository;

import com.example.demo.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    //Just define the function to execute :
    User findByEmailId(String emailId);

    //prebuilt function and you can use it directly

    //Imp thing is you have to define those functions....

}
