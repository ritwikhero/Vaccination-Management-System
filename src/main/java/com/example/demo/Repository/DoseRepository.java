package com.example.demo.Repository;

import com.example.demo.Models.Dose;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoseRepository extends JpaRepository<Dose,Integer> {
}
